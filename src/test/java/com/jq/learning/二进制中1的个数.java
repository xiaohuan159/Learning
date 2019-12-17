package com.jq.learning;

public class 二进制中1的个数 {
    public static void main(String[] args) {
//        System.out.println(NumberOf1(-1));
        test(-2);
    }

    public static int NumberOf1(int n) {
        if (n == -2147483648){
            return 1;
        }
        int count = 0;
        int count1 = 0;
        int n1 = Math.abs(n);
        int n2 = n1;
        while (n1 / 2 > 0) {
            if (n1 % 2 == 1) {
                ++count;
            }
            n1 = n1 / 2;
        }
        if (n1 % 2 == 1) {
            ++count;
        }
        if (n < 0) {
            while (n2%2==0){
                ++count1;
                n2 /= 2;
            }
            count = 32 - count -count1+1;
        }
        return count;

    }


    public static void test(int n){
        System.out.println((n-1)&(n));
    }
}
