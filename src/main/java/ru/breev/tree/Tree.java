package ru.breev.tree;

public interface Tree<E extends Comparable<? super E>> {


    boolean add(E value);

    boolean remove(E value);

    boolean find(E value);

    boolean isEmpty();

    void display();

}
