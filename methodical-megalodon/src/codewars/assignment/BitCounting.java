package codewars.assignment;

public class BitCounting {
    public static int countBits(int n) {
        String binary = getBinaryRepresentation(n);
        binary = binary.replace("0", "");
        return binary.length();
    }

    public static String getBinaryRepresentation(int n) {
        if (n >= 0) {
            return convertToBinaryFromDecimal(n);
        } else {
            n *= -1;
            return formTwosComplement(convertToBinaryFromDecimal(n));
        }
    }

    public static String formTwosComplement(String binary) {
        //b-1-complement
        String onesComplement = formOnesComplement(binary);
        //b-complement
        char[] binaryArray = onesComplement.toCharArray();

        int index = onesComplement.length() - 1;
        if (index >= 0) {
            while (binaryArray[index] == '1') {
                binaryArray[index] = '0';
                index--;
            }
            binaryArray[index] = '1';
        }

        //fill out the holes
        binary = String.valueOf(binaryArray);
        StringBuilder literalBinary = new StringBuilder(binary);

        int binaryActualLength = binary.length();
        while (binaryActualLength < 32) {
            literalBinary.insert(0, 1);
            binaryActualLength++;
        }

        return String.valueOf(literalBinary);
    }

    public static String formOnesComplement(String binary) {
        binary = binary
                .replace("1", "%")
                .replace("0", "1")
                .replace("%", "0");
        return binary;
    }

    public static String convertToBinaryFromDecimal(int n) {
        StringBuilder binaryRepresentation = new StringBuilder();

        while (n > 0) {
            binaryRepresentation.insert(0, n % 2);
            n = n / 2;
        }
        return binaryRepresentation.toString();
    }
}
