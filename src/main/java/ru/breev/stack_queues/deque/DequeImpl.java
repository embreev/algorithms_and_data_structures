package ru.breev.stack_queues.deque;

import ru.breev.stack_queues.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int queueSize) {
        super(queueSize);
    }

    @Override
    public void insertLeft(E element) {
        if (start - 1 < 0) {
            start = data.length;
        }
        data[--start] = element;
        queueSize++;
    }

    @Override
    public void insertRight(E element) {
        super.insert(element);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (end < 0) {
            end = data.length - 1;
        }
        queueSize--;
        return data[end--];
    }
}
