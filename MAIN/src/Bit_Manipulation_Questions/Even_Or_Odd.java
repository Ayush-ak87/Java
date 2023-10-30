package Bit_Manipulation_Questions;

public class Even_Or_Odd {
    
    public static void oddOrEven(int n) {
        int bitmask =1;
        if ((n & bitmask)==0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
    public static void main(String[] args) {
        oddOrEven(3);
        oddOrEven(11);
        oddOrEven(14);
    }
}
