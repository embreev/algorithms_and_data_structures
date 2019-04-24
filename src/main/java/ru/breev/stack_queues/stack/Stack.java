package ru.breev.stack_queues.stack;

public interface Stack<E> {

    E pop();

    void push(E element);

    E peek();

    boolean empty();

    boolean full();
}
