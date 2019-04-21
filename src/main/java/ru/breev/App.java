package ru.breev;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {
    final static Random random = new Random();
    final static int CAPACITY = 1000000;

    static Array<Integer> array;
    static Array<Integer> tmpArray;

    static float startTime;
    static float stopTime;

    public static void main(String[] args) {
        array = new ArrayImpl<>(CAPACITY);
        fillInt();
        System.out.println(array);

        tmpArray = new ArrayImpl<>(CAPACITY);

        copyArray();
        startTime = System.nanoTime();
        tmpArray.sortBubble();
        stopTime = System.nanoTime();
        System.out.println("Bubble: " + TimeUnit.NANOSECONDS.toSeconds((long) (stopTime - startTime)));

        copyArray();
        startTime = System.nanoTime();
        tmpArray.sortSelect();
        stopTime = System.nanoTime();
        System.out.println("Select: " + TimeUnit.NANOSECONDS.toSeconds((long) (stopTime - startTime)));

        copyArray();
        startTime = System.nanoTime();
        tmpArray.sortInsert();
        stopTime = System.nanoTime();
        System.out.println("Insert: " + TimeUnit.NANOSECONDS.toSeconds((long) (stopTime - startTime)));

        System.out.println(tmpArray);
    }

    private static void copyArray() {
        for (int i = 0; i < array.size(); i++) {
            tmpArray.add(array.get(i));
        }
    }

    private static void fillInt() {
        for (int i = 0; i < CAPACITY; i++) {
            array.add(random.nextInt(10));
        }
    }
}
