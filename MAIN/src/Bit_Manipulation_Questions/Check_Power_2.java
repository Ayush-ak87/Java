package Bit_Manipulation_Questions;

public class Check_Power_2 {
    
    public static boolean isPowerofTwo(int n) {
        return (n&(n-1))==0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerofTwo(8));
    }
}
