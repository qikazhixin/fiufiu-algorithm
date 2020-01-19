package org.fiufiu.chapter1.program.model.data;

public interface Queue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}
