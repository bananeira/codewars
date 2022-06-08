package codewars.assignment;

import java.text.DecimalFormat;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        DecimalFormat formatter = new DecimalFormat("00");

        if ( 0 > seconds || seconds > 359999 ) {
            return "no. why?";
        }

        return String.format("%s:%s:%s",
            formatter.format(seconds / 3600),
            formatter.format(seconds / 60 % 60),
            formatter.format(seconds % 60));
    }

    public static String makeReadableShort(int seconds) {
        return ( seconds > 0 && seconds < 359999 )
            ? String.format("%02d:%02d:%02d",
            seconds / 3600,
            seconds / 60 % 60,
            seconds % 60)
            : "no. why?";
    }
}