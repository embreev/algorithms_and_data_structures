package ru.breev.linked_list;

import java.util.Iterator;

public interface LinkedList<E>{

    void insert(E value);

    E removeElement();

    boolean remove(E value);

    boolean isEmpty();

    int getSize();

    boolean find(E value);

    void display();

    E getFirstElement();

    Entry<E> getFirst();
}
