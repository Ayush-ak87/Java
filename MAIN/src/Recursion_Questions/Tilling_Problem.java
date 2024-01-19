package Recursion_Questions;

public class Tilling_Problem {
    public static int tillingProblem(int n) { // 2*n floor Size
        if (n==0||n==1) {
            return 1;
        }
        int fnm1 = tillingProblem(n-1);
        int fnm2 = tillingProblem(n-2);
        int totalways = fnm1 + fnm2;
        return totalways;
    }
    public static void main(String[] args) {
        System.out.println(tillingProblem(3));
    }
}
