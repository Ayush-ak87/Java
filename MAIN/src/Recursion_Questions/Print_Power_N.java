package Recursion_Questions;

public class Print_Power_N {
    public static int power(int n, int x) {
        if (n==0) {
            return 1;
        }
        int xnm1 = power(n-1, x);
        int xn = x*xnm1;
        return xn;
    }
    public static void main(String[] args) {
        System.out.println(power(10, 2));
    }
}
