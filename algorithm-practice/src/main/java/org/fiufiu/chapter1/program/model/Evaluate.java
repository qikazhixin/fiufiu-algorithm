package org.fiufiu.chapter1.program.model;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {

    public static void main(String[] args) {

        //1.两个栈，分别存number和operator
        //2.遇到数字组push进number stack
        //3.遇到操作组push进operator stack
        //4.遇到左括号忽略
        //5.遇到右括号，pop一个操作符和两个数，进行操作

        Stack<String> operator = new Stack<String>();
        Stack<Double> number = new Stack<Double>();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                operator.push(s);
            } else if(s.equals("-")) {
                operator.push(s);
            } else if(s.equals("*")) {
                operator.push(s);
            } else if(s.equals("/")) {
                operator.push(s);
            } else if(s.equals("(")) {

            } else if(s.equals(")")) {
                String pop = operator.pop();
                Double op2 = number.pop();
                if (pop.equals("+")) {
                    number.push(number.pop() + op2);
                } else if(pop.equals("-")) {
                    number.push(number.pop() - op2);
                } else if(pop.equals("*")) {
                    number.push(number.pop() * op2);
                } else if(pop.equals("/")) {
                    number.push(number.pop() / op2);
                }
            } else if(s.equals("stop")) {
                break;
            } else {
                number.push(Double.parseDouble(s));
            }
        }
        StdOut.println("sout");
        StdOut.println(number.pop());
    }
}
