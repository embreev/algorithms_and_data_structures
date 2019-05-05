package ru.breev.recursion;

public class Factorial {

    static int fact(int value) {
        while (value != 1) {
            return value * fact(value - 1);
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
