package pl.coderslab;

public class CountConformingBitmasks {
    public int solution(int A, int B, int C) {
        if(A== 0 & B== 0 & C == 0) return (int)Math.pow(2,30);
        if(A==B & B==C) return 1;

        // Create bitmasks
        int bitmaskA = A;
        int bitmaskB = B;
        int bitmaskC = C;

        for (int i = 0; i < 30; i++) {
            if (((A >> i) & 1) == 0) {
                bitmaskA &= ~(1 << i); // Clear bit i if A doesn't have bit i set
            }
            if (((B >> i) & 1) == 0) {
                bitmaskB &= ~(1 << i); // Clear bit i if B doesn't have bit i set
            }
            if (((C >> i) & 1) == 0) {
                bitmaskC &= ~(1 << i); // Clear bit i if C doesn't have bit i set
            }
        }

        // Loop through all unsigned 30-bit integers and count conforming ones
        int count = 0;
        for (int i = 0; i < (1 << 30); i++) {
            if (((i & bitmaskA) == bitmaskA) || ((i & bitmaskB) == bitmaskB) || ((i & bitmaskC) == bitmaskC)) {
                count++;
            }
        }

        return count;
    }
//    public int solution(int A, int B, int C) {
//
//        if(A==0 && B == 0 && C==0){
//            return (int)Math.pow(2,30);
//        }
//        if(A==B & B==C) return 1;
//        int countA = countConforming(A);
//        int countB = countConforming(B);
//        int countC = countConforming(C);
//
//        int countAB = countConforming(A & B);
//        int countAC = countConforming(A & C);
//        int countBC = countConforming(B & C);
//        int countABC = countConforming(A & B & C);
//
//        int result =  countA + countB + countC - countAB - countAC - countBC + countABC;
//
//        System.out.println(result);
//        return result;
//
//    }


    private int countConforming(int mask) {
        int freeBits = 0;

        // Count the number of free bits (bits that are 0 in the mask)
        for (int i = 0; i < 30; i++) {
            if ((mask & (1 << i)) == 0) {
                freeBits++;  // Wolny bit (może być 0 lub 1)
            }
        }
        freeBits = 30 - freeBits;

        // If no free bits, only one number can conform (the number itself)
        if (freeBits == 0) {
            return 1;
        }

        // If there are free bits, 2^freeBits numbers can conform
        return 1 << freeBits;
    }

}
