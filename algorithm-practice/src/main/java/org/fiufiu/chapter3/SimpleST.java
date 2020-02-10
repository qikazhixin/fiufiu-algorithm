package org.fiufiu.chapter3;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public class SimpleST<T, E> implements ST<T, E> {

    private Node head;

    @Override
    public void put(T key, E value) {

        for (Node x = head;x!=null;x=x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }

        }
        head = new Node(key, value, head);

    }

    @Override
    public E get(T key) {
        for (Node x = head; x!=null; x=x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<T> keys() {
        return null;
    }

    class Node{
        T key;
        E value;
        Node next;

        public Node(T key, E value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
