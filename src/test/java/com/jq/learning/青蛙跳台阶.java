package com.jq.learning;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 青蛙跳台阶 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(5));
    }
    public static int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        int x = target / 2;


        if (target%2==0){
            int temp = 1;
            for (int i = 1; i <= x; i++) {
                temp+= cal(i,x);
            }
            return temp;
        }else {
            int temp = x+1;
            for (int i = 1; i <= x; i++) {
                int cal = cal(i, x);
                temp+=cal *(x+1-i);
            }
            return temp;
        }
    }

    public static int  cal(int x,int total){
        int mul=1;
        for (int i = 1; i <=x; i++) {
            mul *= i;
        }
        int mul1 = 1;
        for (int i = 1; i <=x ; i++) {
            mul1 *= (total--);
        }
        return mul1/mul;

    }
}
