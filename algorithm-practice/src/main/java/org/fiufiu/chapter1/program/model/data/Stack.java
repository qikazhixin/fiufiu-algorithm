package org.fiufiu.chapter1.program.model.data;

public interface Stack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
