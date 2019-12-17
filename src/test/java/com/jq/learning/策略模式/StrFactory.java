package com.jq.learning.策略模式;

import java.util.Map;

public class StrFactory {
    private static final Map<String, Strategy> FinalMap = Map.of(
            "A", new ConcreteStrategyA(),
            "B", new ConcreteStrategyB()
    );

    public static Strategy getStratrgy(String Key) {

        try {
            return FinalMap.get(Key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
