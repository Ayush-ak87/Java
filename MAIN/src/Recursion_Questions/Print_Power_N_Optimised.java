package Recursion_Questions;

public class Print_Power_N_Optimised {
    public static int optimisedPower(int a, int n) {
        if (n==0) {
            return 1;
        }
        int halfPowerSq = optimisedPower(a, n/2)*optimisedPower(a, n/2);
        // n is odd
        if (n%2!=0) {
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }
    public static void main(String[] args) {
    int a = 2;
    int n = 5;
    System.out.println(optimisedPower(a, n));    
    }
}
