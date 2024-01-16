package Recursion_Questions;

public class Print_Number_Dec {
    public static void printDec(int n) {
        if (n==1) {
            System.out.println(1);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    public static void main(String[] args) {
        int n = 2;
        printDec(n);
    }
}
