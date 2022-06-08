package codewars.assignment;

public class TortoiseRacing {
    public static int[] race(int v1, int v2, int g) {
        if ((v1 >= v2) || g <= 0) {
            return null;
        } else {
            float lead = (float) g;

            return new int[]{
                (int) Math.floor(-lead/(v1-v2)),
                (int) Math.floor((timeNeededHours * 3600) / 60 % 60),
                (int) Math.floor((timeNeededHours * 3600) % 60)
            };
        }
    }
}
