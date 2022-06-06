package codewars.assignment;

public class TortoiseRacing {
    public static int[] race(int v1, int v2, int g) {
        if ((v1 >= v2) || g <= 0) {
            return null;
        } else {
            float lead = (float) g;
            float timeNeededHours = -lead/(v1-v2);
            float timeNeededSec = timeNeededHours * 3600;

            return new int[]{
                (int) Math.floor(timeNeededHours),
                (int) Math.floor(timeNeededSec / 60 % 60),
                (int) Math.floor(timeNeededSec % 60)
            };
        }
    }
}