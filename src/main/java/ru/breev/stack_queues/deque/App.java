package ru.breev.stack_queues.deque;

public class App {

    public static Deque<Integer> deque;
    public static final int QUEUE_SIZE = 5;

    public static void main(String[] args) {
        deque = new DequeImpl<>(QUEUE_SIZE);

        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        deque.insertRight(7);
        deque.insertRight(8);

        deque.removeLeft();
        deque.removeRight();

        while (!deque.empty()) {
            System.out.println(deque.removeRight());
        }
    }
}
