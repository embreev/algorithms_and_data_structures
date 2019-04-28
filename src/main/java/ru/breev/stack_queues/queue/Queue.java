package ru.breev.stack_queues.queue;

public interface Queue<E> {

    void insert(E element);

    E remove();

    E peek();

    boolean empty();

    boolean full();

    int size();
}
