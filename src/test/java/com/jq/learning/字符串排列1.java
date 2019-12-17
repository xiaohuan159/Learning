package com.jq.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 字符串排列1 {
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> permutation = Permutation(s);
        System.out.println(permutation);

    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    private static void PermutationHelper(char[] toCharArray, int i, ArrayList<String> res) {
        if (i==toCharArray.length-1){
            res.add(String.valueOf(toCharArray));
        }else {
            HashSet<Character> charset = new HashSet<>();
            for (int j = i; j < toCharArray.length; j++) {
                if (j== i||!charset.contains(toCharArray[j])){
                    charset.add(toCharArray[j]);
                    swap(toCharArray,j,i);
                    PermutationHelper(toCharArray,i+1,res);
                    swap(toCharArray,j,i);
                }
            }
        }

    }

    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
