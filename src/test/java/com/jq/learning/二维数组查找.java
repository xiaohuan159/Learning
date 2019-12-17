package com.jq.learning;

public class 二维数组查找 {
    public static void main(String[] args) {
        int[][] x = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] y = {{}};
        System.out.println(Find(1,y));
    }
    public static boolean Find(int target, int [][] array) {
        int height = array.length;
        int[] ints = array[array.length-1];
        int length = ints.length;
        if (height == 0||length==0){
            return false;
        }
        if (target<array[0][0]||target>array[height-1][length-1]){
            return false;
        }
        for (int[] ints1 : array) {

            if (target<ints1[0]||target>ints1[length -1]){
                continue;
            }
            for (int i : ints1) {
                if (target == i){
                    return true;
                }
            }
        }

        return false;
    }
}
