import codewars.assignment.HumanReadableDurationFormat;
import codewars.assignment.IsNumberAPrime;
import codewars.assignment.TortoiseRacing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(HumanReadableDurationFormat.formatDuration(852734));

        System.out.println(Arrays.toString(new boolean[]{
                IsNumberAPrime.isPrime(27)
            }
        ));

        System.out.println(Arrays.toString(new boolean[]{
                IsNumberAPrime.isPrime(3)
            }
        ));

        System.out.println(Arrays.toString(TortoiseRacing.race(750, 820, 90)));
    }
}