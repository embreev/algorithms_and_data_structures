package ru.breev.linked_list;

public interface Entry<T> {

    T getValue();

    Entry<T> getNext();

    void setNext(Entry<T> nextElement);
}
