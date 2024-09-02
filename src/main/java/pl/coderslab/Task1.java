package pl.coderslab;

import java.util.Arrays;
import java.util.HashMap;

public class Task1 {
    public int solution(int[] A){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 1; i< 1000000;i++ ){
            map.put(i,0);
        }
        for (int i = 0; i < A.length ; i++) {
            if(A[i] > 0){
                map.replace(A[i],0,1);
            }
        }
        return 1;


    }
}
