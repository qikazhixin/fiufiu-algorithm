package org.fiufiu.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode code = new GrayCode();
        System.out.println(code.grayCode(3).toString());
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    /*public List<Integer> grayCode(int n) {
        LinkedList<Integer> ls = new LinkedList<>();
        ls.add(0);
        int[] biny = new int[n+1];
        biny[1]=0b1;
        for (int i=2;i<=n;i++) {
            biny[i]=biny[i-1]<<1;
        }
        for (int i=1;i<=n;i++) {
            Iterator<Integer> iterator = ls.descendingIterator();
            ls = new LinkedList<>(ls);
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                ls.addLast(biny[i]+ next);
            }
//            int size = ls.size();
//            for (int j=size-1;j>=0;j--) {
//                ls.addLast(biny[i]+ls.get(j));
//            }
        }
        return ls;
    }*/
}
