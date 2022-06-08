package codewars.assignment;

public class MatrixAddition {
    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int[][] sum = new int[a.length][a.length];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                sum[i-1][j-1] = a[i-1][j-1] + b[i-1][j-1];
            }
        }

        return sum;
    }
}
