package org.fiufiu.chapter1.program.model.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;

    public void add(Item item) {
        Node old = first;
        Node nItem = new Node(item);
        nItem.next = first;
        first = nItem;

    }

    public static void main(String[] args) {
        Bag<String> s;
        s = new Bag<String>();

        while(!StdIn.isEmpty()) {
            String s1 = StdIn.readString();
            if (s1.equals("ss")) {
                break;
            } else if (!s1.equals("-")) {
                s.add(s1);
            } else {
                StdOut.println(s.toString());
            }
        }
//        StdOut.println("(" + s.size() + " left on stack)");

    }

    @Override
    public String toString() {
        Iterator<Item> iterator = this.iterator();
        StringBuilder builder = new StringBuilder();
        while(iterator.hasNext()) {
            builder.append(iterator.next() + ",");
        }
        return builder.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item tmp = current.item;
                current = current.next;
                return tmp;
            }
        };
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
