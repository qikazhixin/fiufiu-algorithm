package org.fiufiu.chapter1.program.model.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int index;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
        index = 0;
    }

    public void push(Item item) {
        if (index == a.length) {
            resize(1*a.length);
        }
        a[index++] = item;

    }

    public Item pop(){
        Item res = a[--index];
        a[index] = null;
        if (index > 0 && index == a.length/4) {
            resize(a.length/2);
        }
        return res;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void resize(int max) {
        Item[] t = (Item[]) new Object[max];
        for (int i = 0; i<index; i++) {
            t[i] = a[i];
        }
        a = t;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<String>(100);

        while(!StdIn.isEmpty()) {
            String s1 = StdIn.readString();
            if (s1.equals("ss")) {
                break;
            } else if (!s1.equals("-")) {
                s.push(s1);
            } else if (!s.isEmpty()){
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");

    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    class ReverseArrayIterator implements Iterator<Item> {

        private int i = index;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
