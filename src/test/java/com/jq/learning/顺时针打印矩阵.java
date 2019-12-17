package com.jq.learning;

import java.util.ArrayList;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
如果输入如下4 X 4矩阵：
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
则依次打印出数字
1,2,3,4,
8,12,16,15,
14,13,9,5,
6,7,11,10.
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] ints = new int[5][1];
        ints[0][0] = 0;
        ints[1][0] = 1;



        ArrayList<Integer> integers = printMatrix(ints);
        for (Integer integer : integers) {
            System.out.print(integer.toString()+" ");
        }


    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (matrix.length == 0)return null;
        int i = 0,row = matrix.length-1,cul = matrix[0].length-1;
        while (i<=row&&i<=cul){
            print(i, row, cul, matrix, integers);
            i++;
            row--;
            cul--;
        }
        return integers;
    }
    public static void print(int i,int row,int cul,int [][] matrix,ArrayList<Integer> arr){
        int x=i,y=i;
        for (int j = 0; j < cul-i+1; j++)arr.add(matrix[x][y++]);
        --y;
        ++x;
        if (x>row||y<0)return;
        for (int j = 0; j < row-i; j++)arr.add(matrix[x++][y]);
        --x;
        --y;
        if (x>row||y<0)return;
        for (int j = 0; j <cul-i ; j++)arr.add(matrix[x][y--]);
        ++y;
        --x;
        if (x>row||y<0)return;
        for (int j = 0; j <row-i-1 ; j++)arr.add(matrix[x--][y]);
    }
}
