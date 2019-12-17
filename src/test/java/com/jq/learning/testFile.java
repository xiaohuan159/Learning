package com.jq.learning;

import java.io.File;

public class testFile {
    public static void main(String[] args) {
        String houzhui = ".png";
        String path = "C:/Users/10691/Desktop/从 0 开始带你成为JVM实战高手/从 0 开始带你成为JVM实战高手/";
        File file = new File(path);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                String name = file1.getName();
                String substring = name.substring(0, 3);

//                file1.renameTo(substring)
                file1.renameTo(new File(path + substring + houzhui));

            }
        }
    }
}
