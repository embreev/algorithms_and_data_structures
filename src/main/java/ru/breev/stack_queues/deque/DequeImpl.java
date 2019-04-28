package ru.breev.stack_queues.deque;

import ru.breev.stack_queues.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int queueSize) {
        super(queueSize);
    }

    @Override
    public void insertLeft(E value) {
        if ()
    }

    @Override
    public void insertRight(E value) {
        super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        return null;
    }
}
