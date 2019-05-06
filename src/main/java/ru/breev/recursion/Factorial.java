package ru.breev.recursion;

public class Factorial {

    static int fact(int value) {
        if (value == 1) {
            return value;
        }
        return value * fact(value - 1);
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
