package ru.breev.stack_queues.hw;

import ru.breev.stack_queues.stack.Stack;
import ru.breev.stack_queues.stack.StackImpl;

public class Reverse {

    private static String str = "переворотповорот";
    private static Stack<Character> stack = new StackImpl<>(str.length());

    public static void main(String[] args) {

        char[] arrayStr = str.toCharArray();
        for (char c: arrayStr){
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
