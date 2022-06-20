package codewars.assignment;

public class ArithmeticProgression {
    public static int findMissing(int[] numbers) {
        int missing = 0;
        int stepSize = ( numbers[numbers.length - 1] - numbers[0] ) / numbers.length;

        for (int i = 0; i < numbers.length; i++) {
            if ( numbers[( i + 1 ) % ( numbers.length - 1 )] - numbers[i] != stepSize ) {
                missing = numbers[i] + stepSize;
                break;
            } else if ( numbers[( i + 1 ) % ( numbers.length - 1 )] - numbers[i] == 0 ) {
                missing = numbers[i];
                break;
            }
        }

        return missing;
    }
}
