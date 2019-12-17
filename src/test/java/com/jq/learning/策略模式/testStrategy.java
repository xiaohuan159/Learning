package com.jq.learning.策略模式;

import java.lang.reflect.InvocationTargetException;

public class testStrategy {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Strategy a = StrFactory.getStratrgy("C");
        if (a == null){
            System.out.println("hehe");
        }else {
            a.test();
        }
    }
}
