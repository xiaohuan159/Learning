package com.jq.learning;

public class 空格替换 {
    public static void main(String[] args) {

    }
    public static String replaceSpace(StringBuffer str) {

        char[] chars = str.toString().toCharArray();
        str = new StringBuffer("");
        for (char aChar : chars) {
            if (aChar == ' '){
                str.append("%20");
                continue;
            }
            str.append(aChar);
        }

        return str.toString();
    }
}
