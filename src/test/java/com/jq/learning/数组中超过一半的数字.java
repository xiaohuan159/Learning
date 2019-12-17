package com.jq.learning;

import java.util.ArrayList;
import java.util.Collections;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中超过一半的数字 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution1(arr));
    }
    public static int MoreThanHalfNum_Solution1(int [] array) {
        int temp = array[0];
        int count = 1;
        for (int i = 1; i < array.length ; i++) {
            if (array[i] == temp){
                count++;
            }else {
                count--;
                if (count==0){
                    temp = array[i];
                    count= 1;
                }
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == temp){
                count++;
            }
        }
        return count>array.length/2?temp:0;
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : array) {
            integers.add(i);
        }
        Collections.sort(integers);
        int temp = 0;
        int count = 0;
        for (Integer integer : integers) {
            if (temp == integer){
                count++;
            }else {
                temp = integer;
                count = 1;
            }
            if (count >array.length/2){
                return temp;
            }
        }
        return 0;
    }

}
