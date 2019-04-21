package ru.breev;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {
    final static Random random = new Random();
    final static int CAPACITY = 100000;

    static Array<Integer> array;
    static Array<Integer> tmpArray;

    static float startTime;
    static float stopTime;

    public static void main(String[] args) {
        array = new ArrayImpl<>(CAPACITY);
        fillInt();
        System.out.println(array);

    }

    private static void fillInt() {
        for (int i = 0; i < CAPACITY; i++) {
            array.add(random.nextInt(10));
        }
    }
}
