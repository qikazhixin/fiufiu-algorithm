package org.fiufiu.chapter1.program.model.data;

/**
 * @author Like Liu
 * @description
 * @since Oracle JDK1.8
 **/
public interface Bag<Item> extends Iterable<Item> {

    void add(Item item);

    boolean isEmpty();

    int size();
}
