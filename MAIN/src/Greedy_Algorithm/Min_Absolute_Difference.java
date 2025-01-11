package Greedy_Algorithm;

import java.util.Arrays;

public class Min_Absolute_Difference {
    public static void main(String[] args) {
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Minimum absolute difference pair = " + minDiff);
    }
}
