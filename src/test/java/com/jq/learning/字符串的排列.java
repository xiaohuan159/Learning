package com.jq.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        String s = "abcd";
        ArrayList<String> permutation = Permutation(s);
        System.out.println(permutation);
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> strings = new ArrayList<>();
        if (str!=null&&str.length()!=0){
            PermutationHelper(str.toCharArray(),0,strings);
            Collections.sort(strings);
        }
        return strings;
    }



    private static void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }




    private static void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
