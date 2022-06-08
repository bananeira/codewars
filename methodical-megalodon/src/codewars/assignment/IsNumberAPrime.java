package codewars.assignment;

public class IsNumberAPrime {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
