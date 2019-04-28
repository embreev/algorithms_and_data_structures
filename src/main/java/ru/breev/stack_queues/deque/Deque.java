package ru.breev.stack_queues.deque;

import ru.breev.stack_queues.queue.Queue;

public interface Deque<E> extends Queue<E> {

    void insertLeft(E element);
    void insertRight(E element);

    E removeLeft();
    E removeRight();

}
