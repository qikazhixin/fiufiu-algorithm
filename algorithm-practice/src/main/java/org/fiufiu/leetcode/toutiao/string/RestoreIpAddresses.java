package org.fiufiu.leetcode.toutiao.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class RestoreIpAddresses {

    @Test
    public void test() {
        /*Assert.assertArrayEquals(
                new String[]{"255.255.111.35", "255.255.11.135"},
                restoreIpAddresses("25525511135").toArray());*/
        Assert.assertArrayEquals(
                new String[]{"1.1.1.1"},
                restoreIpAddresses("1111").toArray());

    }

    public List<String> restoreIpAddresses(String s) {
        //0-255
        //回溯
        int length = s.length();
        if (length<4||length>12) {
            return Collections.emptyList();
        }
        res=new ArrayList<>();
        ls=new LinkedList<>();
        this.s=s;
        len=s.length();
        backtrace(-1, 4);
        return res;
    }

    String s;
    List<String> res;
    LinkedList<String> ls;
    int len;
    private void backtrace(int index, int last) {
        if (index>=len-last) {
            return;
        }
        if (last==1) {
            Integer integer = Integer.valueOf(s.substring(index + 1));
            if (integer>=0&&integer<=255&&integer.toString().length()==len-1-index) {
                StringBuilder builder = new StringBuilder();
                Iterator<String> iterator = ls.iterator();
                while(iterator.hasNext()) {
                    builder.append(iterator.next()).append(".");
                }
                builder.append(integer);
                res.add(builder.toString());
            }
            return;
        }

            char c = s.charAt(index + 1);
            if (c ==48) {

            } else {
                if (c>50){

                } else {
                    if (index + 4 <=len) {
                        ls.add(s.substring(index+1, index+4));
                        backtrace(index+3, last-1);
                        ls.removeLast();
                    }
                }
                if (index + 3<=len) {

                    ls.add(s.substring(index+1, index+3));
                    backtrace(index+2, last-1);
                    ls.removeLast();
                }
            }
            ls.add(s.substring(index+1, index+2));
            backtrace(index+1, last-1);
            ls.removeLast();

    }


    /*public List<String> restoreIpAddresses(String s) {
        //0-255
        //回溯
        int length = s.length();
        if (length<4||length>12) {
            return Collections.emptyList();
        }
        List<String> ls=new ArrayList<>();

        for (int i=0;i<3;i++) {
            if (length-i-1<3||length-i-1>9) {
                continue;
            }
            Integer integer = Integer.valueOf(s.substring(0, i + 1));
            if (integer >=0&&integer<=255) {
                for (int j=i+1;j<i+4;j++) {
                    if (length-j-1<2||length-j-1>6) {
                        continue;
                    }
                    Integer integer1 = Integer.valueOf(s.substring(i + 1, j + 1));
                    if (integer1 >=0&&integer1<=255) {
                        for (int k=j+1;k<j+4;k++) {
                            if (length-k-1<1||length-k-1>3) {
                                continue;
                            }
                            Integer integer2 = Integer.valueOf(s.substring(j + 1, k+ 1));
                            if (integer2 >=0&&integer2<=255) {
                                Integer integer3 = Integer.valueOf(s.substring(k+1));
                                if (integer3 >=0&&integer3<=255) {
                                    String e = new StringBuilder().append(integer).append(".")
                                            .append(integer1).append(".")
                                            .append(integer2).append(".")
                                            .append(integer3).toString();
                                    if (e.length()==length+3) {
                                        ls.add(e);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        return ls;
    }*/
}
