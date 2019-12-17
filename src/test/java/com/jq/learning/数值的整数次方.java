package com.jq.learning;
/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        System.out.println(Power(2.0,3));
    }
    public static double Power(double base, int exponent) {
        double res = 1,curr = base;
        int zhishu;
        if (exponent > 0){
            zhishu  = exponent;
        }else if (exponent <0){
            if (base == 0){
                throw new RuntimeException("指数为负,底数不能为0");
            }
            zhishu = -exponent;
        }else {
            return 1;
        }
        while (zhishu!=0){
            if ((zhishu&1) == 1){

                res*=curr;
            }
            curr*=curr;
            zhishu>>=1;

        }
        return exponent>0? res: (1/res);

    }
}
