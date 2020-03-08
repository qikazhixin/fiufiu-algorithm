package org.fiufiu.chapter1.program.model.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item>{

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {

        Node node = new Node(item);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = last.next;
        }
        size++;

    }

    public Item dequeue() {
        Item res = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return res;
    }

    public static void main(String[] args) {
        Queue<String> s;
        s = new Queue<String>();

        while(!StdIn.isEmpty()) {
            String s1 = StdIn.readString();
            if (s1.equals("ss")) {
                break;
            } else if (!s1.equals("-")) {
                s.enqueue(s1);
            } else if (!s.isEmpty()){
                StdOut.print(s.dequeue() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");

    }

    private class Node{
       Item item;
       Node next;

        public Node(Item item) {
            this.item = item;
            next = null;
        }
    }
}
