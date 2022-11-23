import codewars.assignment.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //get random number
        Random random = new Random();
        //get array for random numbers
        int[] randomArray = new int[100];
        //store random numbers in array
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt();
        }

        for (int i = 0; i < randomArray.length; i++) {
            System.out.println("Number: " + randomArray[i]);
            System.out.println("Got binary: " + BitCounting.getBinaryRepresentation(randomArray[i]));
            System.out.println("Should return binary: " + Integer.toBinaryString(randomArray[i]));
            System.out.println("Got: " + BitCounting.countBits(randomArray[i]));
            System.out.println("Should return: " + Integer.bitCount(randomArray[i]) + "\n");
        }
    }
}