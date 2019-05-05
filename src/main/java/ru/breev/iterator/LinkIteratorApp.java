package ru.breev.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkIteratorApp {

    public static void main(String[] args) {

        List<Character> ll = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('c');
        ll.add('d');

        Iterator iterator = ll.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
