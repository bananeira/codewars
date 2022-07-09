package codewars.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HumanReadableDurationFormat {
    public static String formatDuration(int seconds) {
        StringBuilder duration = new StringBuilder();
        String[] dimensions = new String[]{"second", "minute", "hour", "day", "year"};
        int[] padding = new int[]{60, 60, 24, 365, Integer.MAX_VALUE};
        int[] scalingFromSec = new int[]{1, 60, 3600, 86400, 31536000, Integer.MAX_VALUE};
        List<String> entries = new ArrayList<>();

        for (int i = 0; i < dimensions.length; i++) {
            dimensions[i] = seconds / scalingFromSec[i] == 1 || seconds / scalingFromSec[i] % padding[i] == 1
                ? dimensions[i]
                : dimensions[i] + "s";
        }

        for (int i = dimensions.length; i-- > 0; ) {
            int i1 = ( i > 0 ) ? seconds / scalingFromSec[i] % padding[i] : seconds % padding[i];
            if ( ( ( seconds / scalingFromSec[i] == 1 ) || ( i1 == 1 ) ) && seconds / scalingFromSec[i + 1] < 1 ) {
                entries.add("1 " + dimensions[i]);
            } else if ( ( ( seconds / scalingFromSec[i] > 1 ) || ( i1 > 1 ) ) && i1 != 0 ) {
                entries.add(i1 + " " + dimensions[i]);
            }
        }

        IntStream.range(0, entries.size()).forEach(index -> {
            duration.append(entries.get(index));
            appendEntry(duration, entries, index);
        });

        return entries.isEmpty() ? "now" : duration.toString();
    }

    private static void appendEntry(StringBuilder duration, List<String> entries, int index) {
        int entryValue = entries.size() - 2;
 
        if ( index == entryValue ) {
            duration.append(" and ");
        }

        if ( index < entryValue ) {
            duration.append(", ");
        }
    }
}