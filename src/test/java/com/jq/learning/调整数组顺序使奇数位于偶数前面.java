package com.jq.learning;

import java.util.ArrayList;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,4,3,5,1,2,4,7};
        reOrderArray1(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
    public static void reOrderArray1(int [] array) {
            int x = array.length;
            int y = 0;
            for (int i = 0; i < x; i++) {
                if (array[i]%2 == 1){
                    int j  = i;
                    while (j>y){
                        if (array[j-1]%2 == 0){
                            swap(j,array);
                            j--;
                        }
                        else {
                            j =0;
                        }
                    }
                    ++y;
                }
            }
    }

    private static void swap(int i, int[] array) {
        int x = array[i];
        array[i] = array[i-1];
        array[i-1] = x;
    }

    public static void reOrderArray(int [] array) {
        ArrayList<Integer> oddArr = new ArrayList<>();
        ArrayList<Integer> evenArr = new ArrayList<>();
        for (int i : array) {
            if (i%2==0){
                oddArr.add(i);
            }else {
                evenArr.add(i);
            }
        }
        evenArr.addAll(oddArr);
        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = evenArr.get(i);
        }

    }
}
