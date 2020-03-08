package org.fiufiu.chapter1.program.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class CardLevel {

    public static void main(String[] args) {
        CardLevel cardLevel = new CardLevel();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            System.out.println(cardLevel.level(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] first = new int[15];
    private int[] second = new int[4];

    private String level(String s) {
        String[] cards = s.split(" ");
        for (int i=0;i<cards.length;i++) {
            int index1 = transfer(cards[i].charAt(0));
            first[index1]++;
            int index2 = cards[i].charAt(1)-65;
            second[index2]++;
        }
        return countLevel();
    }

    private int transfer(char c) {
        if (c>48 && c<58) {
            return c-48;
        } else {
            return c-65+10;
        }

    }

    private String countLevel() {
        //同花
        boolean samecolor = false;
        for(int i=0;i<4;i++) {
            if (second[i]==5) {
                samecolor = true;
            }
        }
        //顺子
        boolean cons=false;
        //相同
        int sum=1;
        int conss=5;
        for (int i=0;i<15;i++) {
            if (first[i] > sum) {
                sum = first[i];
            } else if(first[i]==0) {
                conss=5;
            } else if (first[i]==1) {
                conss--;
                if (conss==0) {
                    cons=true;
                }
            }
        }
        //同花顺
        if (samecolor&&cons) {
            return "同花顺";
        } else if (samecolor) {
            return "同花";
        } else if (cons) {
            return "顺子";
        } else if (sum > 1) {
            return sum+"个相同";
        } else {
            return "无特殊";
        }

    }
}
