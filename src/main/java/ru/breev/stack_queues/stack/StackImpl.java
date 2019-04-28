package ru.breev.stack_queues.stack;

public class StackImpl<E> implements Stack<E> {


    E[] data;
    int stackSize;

    public StackImpl(int stackSize) {
        this.data = (E[]) new Object[stackSize];
    }

    @Override
    public E pop() {
        if (!empty()) {
            return data[--stackSize];
        }
        return null;
    }

    @Override
    public void push(E element) {
        if (!full()) {
            this.data[stackSize++] = element;
        }
    }

    @Override
    public E peek() {
        if (!empty()) {
            return data[stackSize - 1];
        }
        return null;
    }

    @Override
    public boolean empty() {
        return stackSize == 0;
    }

    @Override
    public boolean full() {
        return data.length == stackSize;
    }

    @Override
    public int size() {
        return data.length;
    }
}
