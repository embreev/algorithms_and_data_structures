package ru.breev;

import java.util.Random;

public class App {
    final static Random random = new Random();
    final static int CAPACITY = 1000000;

    public static void main(String[] args) {
        Array<Integer> array = new ArrayImpl<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            array.add(random.nextInt(10));
        }

        System.out.println(array.toString());
    }
}
