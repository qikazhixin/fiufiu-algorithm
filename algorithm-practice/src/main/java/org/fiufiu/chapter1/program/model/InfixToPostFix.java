package org.fiufiu.chapter1.program.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class InfixToPostFix {

    public static void main(String[] args) {
        InfixToPostFix infixToPostFix = new InfixToPostFix();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String s = bufferedReader.readLine();
                System.out.println(infixToPostFix.infixToPostFix(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Queue<Character> queue = new Queue<>();
    private Stack<Character> stack = new Stack<>();

    private String infixToPostFix(String input) {
        //1.创建一个队列和一个栈
        //2.从左至右扫描数组
        //3.若是数字则放入队列，若是op，+-*/则将栈顶优先级大于等与其的弹出至队列在压入，
        //若是(，则直接压入，若是)，则将)至(弹出,最后顺序输出队列在从顶之下弹出栈
        char[] chars = input.toCharArray();
        for (int i=0; i<chars.length; i++) {

            Character tmp;
            switch (chars[i]) {
                case '(':

                    stack.push(chars[i]);
                    break;
                case ')':

                    do {
                        tmp = stack.pop();
                        if (tmp != '(') {
                            queue.enqueue(tmp);
                        }
                    } while (tmp != '(');
                    break;
                case '+':
                    if (stack.empty()) {
                        tmp = null;
                    } else {

                        tmp = stack.peek();
                    }
                    while(tmp != null && tmp != '(') {
                        queue.enqueue(stack.pop());
                        if (stack.empty()) {
                            tmp = null;
                        } else {

                            tmp = stack.peek();
                        }
                    }
                    stack.push(chars[i]);
                    break;
                case '-':
                    if (stack.empty()) {
                        tmp = null;
                    } else {

                        tmp = stack.peek();
                    }
                    while(tmp != null && tmp != '(') {
                        queue.enqueue(stack.pop());
                        if (stack.empty()) {
                            tmp = null;
                        } else {

                            tmp = stack.peek();
                        }
                    }
                    stack.push(chars[i]);
                    break;
                case '*':
                    if (stack.empty()) {
                        tmp = null;
                    } else {
                        tmp = stack.peek();
                    }
                    while((tmp != null && '*' == tmp) || (tmp != null &&'/' == tmp)) {
                        queue.enqueue(stack.pop());
                        if (stack.empty()) {
                            tmp = null;
                        } else {
                            tmp = stack.peek();
                        }
                    }
                    stack.push(chars[i]);
                    break;
                case '/':
                    if (stack.empty()) {
                        tmp = null;
                    } else {
                        tmp = stack.peek();
                    }
                    while((tmp != null && '*' == tmp) || (tmp != null &&'/' == tmp)) {
                        queue.enqueue(stack.pop());
                        if (stack.empty()) {
                            tmp = null;
                        } else {
                            tmp = stack.peek();
                        }
                    }
                    stack.push(chars[i]);
                    break;
                default:
                    queue.enqueue(chars[i]);
            }

        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.dequeue());
        }
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
        return builder.toString();

    }




}
