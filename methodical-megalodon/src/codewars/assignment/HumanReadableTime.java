package codewars.assignment;

import java.text.DecimalFormat;

public class HumanReadableTime {
    public static String makeReadable(int sec) {
        DecimalFormat formatter = new DecimalFormat("00");

        if ( 0 > sec || sec > 359999 ) {
            return "no. why?";
        }

        return String.format("%s:%s:%s",
            formatter.format(sec / 3600),
            formatter.format(sec / 60 % 60),
            formatter.format(sec % 60));
    }

    public static String makeReadableShort(int sec) {
        return ( sec >= 0 && sec < 359999 )
            ? String.format("%02d:%02d:%02d", sec / 3600, sec / 60 % 60, sec % 60) 
            : "no. why?";
    }
}
