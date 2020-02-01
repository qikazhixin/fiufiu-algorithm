package org.fiufiu.chapter1.program.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class Parentheses {

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String s = read.readLine();
                System.out.println(parentheses.parentheses(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private Queue<String> queue = new Queue<>();
    private Stack<String> da = new Stack<>();
    private Stack<String> op = new Stack<>();

    private String parentheses(String s) {
        //1.一个队列一个栈
        //2.从左往右遍历
        //3.若是数字放入队列，若是操作符则放入栈，
        // 若是），则取队列取两个和一个操作符，拼接（，在放入
        //4.顺序输出
        String[] s1 = s.split(" ");
        String tmp;
        for (int i=0; i< s1.length; i++) {
            if (Pattern.matches("^[+\\-*/]$", s1[i])) {
                op.push(s1[i]);
            } else if(Pattern.matches("^[0-9]*$", s1[i])) {
                da.push(s1[i]);

            } else if(")".equals(s1[i])){
                tmp = da.pop();
                da.push("(" + da.pop() + op.pop() + tmp + ")");
            }
        }

        return da.pop();
    }
}
