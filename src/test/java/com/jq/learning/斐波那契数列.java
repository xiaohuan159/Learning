package com.jq.learning;
/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class 斐波那契数列 {
    public static void main(String[] args) {

    }
    public static int Fibonacci(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int x = 1;
        int y = 2;
        for (int i = 0; i < target-2; i++) {
            if (x<y){
                x += y;
            }else {
                y+=x;
            }
        }
        return Math.max(x,y);
    }
}
