package pl.coderslab;

import java.util.Arrays;

public class Binary {
    public int solution(int N){
        char[] binary = Integer.toBinaryString(N).toCharArray();
        int[] binaryNumbers = new int[binary.length];
        int maxLength = 0;
        int currentLength = 0;
        int lastDigit = 1;

        for(int i = 0; i< binary.length; i++){
            binaryNumbers[i] = Character.getNumericValue(binary[i]);
        }

        for (int binaryNumber : binaryNumbers) {

            if (binaryNumber == 1 && lastDigit == 0 && currentLength >= maxLength) {
                maxLength = currentLength;
                currentLength = 0;
                lastDigit = 1;
            }

            else if (binaryNumber == 1 && lastDigit == 0) {
                lastDigit = 1;
                currentLength = 0;
            }

            else if (binaryNumber == 0) {
                currentLength++;
                lastDigit = 0;
            }
        }
        return maxLength;
    }
}
