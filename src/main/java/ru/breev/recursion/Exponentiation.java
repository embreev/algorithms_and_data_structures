package ru.breev.recursion;

public class Exponentiation {

    static int exp(int value, int degree) {
        if (degree == 1) {
            return value;
        }
        return value * exp(value, degree - 1);
    }

    public static void main(String[] args) {
        System.out.println(exp(2, 6));
    }
}
