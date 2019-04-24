package ru.breev.stack_queues.queue;

public class QueueImpl<E> implements Queue<E> {

    E[] data;
    int queueSize;

    int start;
    int end;

    public QueueImpl(int queueSize) {
        this.data = (E[]) new Object[queueSize];
        start = 0;
        end = -1;
    }

    @Override
    public void insert(E element) {
        if (!full()) {
            if (end == data.length - 1) {
                end = -1;
            }
            data[++end] = element;
            queueSize++;
        }
    }

    @Override
    public E remove() {
        if (!empty()) {
            if (start == data.length) {
                start = 0;
            }
        }
        queueSize--;
        return data[start++];
    }

    @Override
    public E peek() {
        return (!empty()) ? data[end] : null;
    }

    @Override
    public boolean empty() {
        return queueSize == 0;
    }

    @Override
    public boolean full() {
        return data.length == queueSize;
    }

    @Override
    public int size() {
        return data.length;
    }
}
