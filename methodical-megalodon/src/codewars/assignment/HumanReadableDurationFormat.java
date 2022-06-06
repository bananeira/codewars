package codewars.assignment;

import java.util.ArrayList;
import java.util.List;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds) {
        String duration;
        String[] dimensions = new String[5];
        int[] padding = new int[]{
            60,
            60,
            24,
            365,
            (int) Double.POSITIVE_INFINITY
        };
        int[] scalingFromSec = new int[]{
            1,
            60,
            3600,
            86400,
            31536000,
            (int) Double.POSITIVE_INFINITY
        };
        String[] format = new String[]{
            "%s",
            "%s and %s",
            "%s, %s and %s",
            "%s, %s, %s and %s",
            "%s, %s, %s, %s and %s"
        };
        List<String> entries = new ArrayList<>();

        if ( seconds == 1 || seconds % padding[0] == 1 ) {
            dimensions[0] = "second";
        } else {
            dimensions[0] = "seconds";
        }


        if ( seconds / scalingFromSec[1] == 1 || seconds / scalingFromSec[1] % padding[1] == 1 ) {
            dimensions[1] = "minute";
        } else {
            dimensions[1] = "minutes";
        }

        if ( seconds / scalingFromSec[2] == 1 || seconds / scalingFromSec[2] % padding[2] == 1 ) {
            dimensions[2] = "hour";
        } else {
            dimensions[2] = "hours";
        }

        if ( seconds / scalingFromSec[3] == 1 || seconds / scalingFromSec[3] % padding[3] == 1 ) {
            dimensions[3] = "day";
        } else {
            dimensions[3] = "days";
        }

        if ( seconds / scalingFromSec[4] == 1 ) {
            dimensions[4] = "year";
        } else {
            dimensions[4] = "years";
        }

        for (int i = dimensions.length; i-- > 0; ) {
            int i1 = ( i > 0 )
                ? seconds / scalingFromSec[i] % padding[i]
                : seconds % padding[i];
            if (
                (
                    ( seconds / scalingFromSec[i] == 1 )
                    || ( i1 == 1 )
                )
                && seconds / scalingFromSec[i + 1] < 1
            ) {
                entries.add("1 " + dimensions[i]);
            } else if (
                (
                    ( seconds / scalingFromSec[i] > 1 )
                    || ( i1 > 1 )
                )
                && i1 / scalingFromSec[i + 1] < 1
                && i1 != 0
            ) {
                entries.add(i1 + " " + dimensions[i]);
            }
        }

        if ( entries.size() == 1 ) {
            duration = String.format(format[entries.size() - 1],
                entries.get(0)
            );
        } else if ( entries.size() == 2 ) {
            duration = String.format(format[entries.size() - 1],
                entries.get(0),
                entries.get(1)
            );
        } else if ( entries.size() == 3 ) {
            duration = String.format(format[entries.size() - 1],
                entries.get(0),
                entries.get(1),
                entries.get(2)
            );
        } else if ( entries.size() == 4 ) {
            duration = String.format(format[entries.size() - 1],
                entries.get(0),
                entries.get(1),
                entries.get(2),
                entries.get(3)
            );
        } else if ( entries.size() == 5 ) {
            duration = String.format(format[entries.size() - 1],
                entries.get(0),
                entries.get(1),
                entries.get(2),
                entries.get(3),
                entries.get(4)
            );
        } else {
            duration = "now";
        }

        return duration;
    }
}