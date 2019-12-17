package com.jq.learning;

import java.math.BigInteger;
import java.util.Stack;

public class 大数相乘 {
    public static void main(String[] args) {
//        System.out.println(add("124165215673487","11657416573213742186415657318341"));
        long l = System.currentTimeMillis();
        BigInteger bigInteger1 = new BigInteger("123456789101112131415161718194232120156124");
        BigInteger bigInteger2 = new BigInteger("2019181716151413121110987654321445152342343");
//        String s2 = "123456789101112131415161718194232120156124";
//        String s1 = "2019181716151413121110987654321445152342343";
//        String temp = "0";
//        for (int i = 0; i < s1.length(); i++) {
//            int index = s1.length() - 1 - i;
//            int c = s1.toCharArray()[index]-'0';
//            String mult = mult(c, s2, i);
//            temp  = add(temp,mult);
//        }
//
//        System.out.println(temp);
        System.out.println(bigInteger1.multiply(bigInteger2));
        System.out.println(System.currentTimeMillis()-l);
    }
    private static String mult(int s1,String s2,int index){
        StringBuilder sb = new StringBuilder("");
        sb.append("0".repeat(index));
        int temp = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s2.toCharArray()) {
            stack.push(c-'0');
        }
       while (!stack.empty()){
           int i = stack.pop() * s1 + temp;
           sb.append(i%10);
           temp = i/10;
       }
        if (temp != 0){
            sb.append(temp);
        }

        return sb.reverse().toString();
    }
    private static String add(String s1 ,String s2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (char c : s1.toCharArray()) {
            stack1.push(c-'0');
        }
        for (char c : s2.toCharArray()) {
            stack2.push(c-'0');
        }
        StringBuilder sb = new StringBuilder("");
        int temp = 0;

        while (!(stack2.empty()&&stack1.empty())){
            Integer pop = stack1.empty()? 0:stack1.pop();
            Integer pop1 = stack2.empty()? 0:stack2.pop();
            sb.append((pop+pop1+temp)%10);
            temp = (pop+pop1+temp)/10;
        }
        return sb.reverse().toString();
    }






    public static String cm(String o, String t) {
        StringBuffer o1 = new StringBuffer(o).reverse();
        StringBuffer t1 = new StringBuffer(t).reverse();
        StringBuilder jg = new StringBuilder("0");
        int sum = 0;//当前位
        for (int i = 0, j; i < o1.length(); i++) {
            for (j = 0; j < t1.length(); j++) {
                sum += (o1.charAt(i) - '0') * (t1.charAt(j) - '0');
                if (jg.length() - 1 < i + j) {
                    jg.append('0');
                }
                sum += jg.charAt(i + j) - '0';
                jg.replace(i + j, i + j + 1, "" + (char) (sum % 10 + '0'));
                sum /= 10;
            }
            while (sum > 0) {
                if (jg.length() - 1 < i + j) {
                    jg.append('0');
                }
                sum += jg.charAt(i + j) - '0';
                jg.replace(i + j, i + j + 1, "" + (char) (sum % 10 + '0'));
                sum /= 10;
                j++;
            }
        }
        return jg.reverse().toString();
    }




    public static long karatsuba(long num1, long num2){
        //递归终止条件
        if(num1 < 10 || num2 < 10) return num1 * num2;

        // 计算拆分长度
        int size1 = String.valueOf(num1).length();
        int size2 = String.valueOf(num2).length();
        int halfN = Math.max(size1, size2) / 2;

        /* 拆分为a, b, c, d */
        long a = Long.parseLong(String.valueOf(num1).substring(0, size1 - halfN));
        long b = Long.parseLong(String.valueOf(num1).substring(size1 - halfN));
        long c = Long.parseLong(String.valueOf(num2).substring(0, size2 - halfN));
        long d = Long.parseLong(String.valueOf(num2).substring(size2 - halfN));

        // 计算z2, z0, z1, 此处的乘法使用递归
        long z2 = karatsuba(a, c);
        long z0 = karatsuba(b, d);
        long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

        return (long)(z2 * Math.pow(10, (2*halfN)) + z1 * Math.pow(10, halfN) + z0);
    }

}
