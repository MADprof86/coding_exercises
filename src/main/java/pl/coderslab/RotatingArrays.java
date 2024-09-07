package pl.coderslab;

import java.util.function.ToDoubleBiFunction;

public class RotatingArrays{
    public int[] solution(int[] A, int K){
        if(K <= 0 || A.length ==0 ) return A;

        int rotations = K % (A.length);
        if (rotations == 0) return A;

        int[] result = new int[A.length];
        for (int i = 0; i < A.length ; i++) {
            int newPosition = (i+rotations) % A.length;
            result[newPosition] = A[i];
        }
        return  result;
    }

}
