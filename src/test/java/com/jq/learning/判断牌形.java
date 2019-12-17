package com.jq.learning;

import java.util.*;

public class 判断牌形 {
    public static final Map<String,Integer> numMap= Collections.unmodifiableMap(new HashMap<>(){
        {

            put("2",2);
            put("3",3);
            put("4",4);
            put("5",5);
            put("6",6);
            put("7",7);
            put("8",8);
            put("9",9);
            put("10",10);
            put("j",11);
            put("q",12);
            put("k",13);
            put("a",14);

        }
    });
    public static final Map<String,Integer> typeMap= Collections.unmodifiableMap(new HashMap<>(){
        {
            put("红桃",0);
            put("方块",1);
            put("黑桃",2);
            put("梅花",3);
        }
    });
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            new card(numMap.get(sc.nextLine()),typeMap.get(sc.nextLine()));
        }
        cards.sort(new Comparator<card>() {
            @Override
            public int compare(card card1, card card2) {
                return card1.num - card2.num;
            }
        });
    }
    static class card{
        public card(int num, int type) {
            this.num = num;
            this.type = type;
        }

        int num;
        int type;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            card card = (card) o;

            return num == card.num;
        }

        @Override
        public int hashCode() {
            return num;
        }
    }
}
