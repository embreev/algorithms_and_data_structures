package ru.breev.stack_queues.queue;

public class App {

    static Queue<Integer> queue = new QueueImpl<>(5);

    public static void main(String[] args) {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);

        System.out.println(queue.peek());

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        System.out.println(queue.peek());

        queue.insert(9);
        queue.insert(9);
        queue.insert(9);
        queue.insert(9);
        queue.insert(9);

        System.out.println(queue.peek());
    }
}
