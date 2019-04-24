package ru.breev.stack_queues.stack;

public class StackImpl<E> implements Stack<E> {


    E[] data;
    int currentSize;

    public StackImpl(int stackSize) {
        this.data = (E[]) new Object[stackSize];
    }

    @Override
    public E pop() {
        if (!empty()) {
            return data[--currentSize];
        }
        return null;
    }

    @Override
    public void push(E element) {
        if (!full()) {
            this.data[currentSize++] = element;
        }
    }

    @Override
    public E peek() {
        if (!empty()) {
            return data[currentSize - 1];
        }
        return null;
    }

    @Override
    public boolean empty() {
        return currentSize == 0;
    }

    @Override
    public boolean full() {
        return data.length == currentSize;
    }
}
