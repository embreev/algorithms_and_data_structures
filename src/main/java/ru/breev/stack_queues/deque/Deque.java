package ru.breev.stack_queues.deque;

import ru.breev.stack_queues.queue.Queue;

public interface Deque<E> extends Queue<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
    E removeRight();

}
