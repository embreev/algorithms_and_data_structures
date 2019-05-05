package ru.breev.linked_list;

public class App {

    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedListImpl<>();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        ll.display();

        System.out.println("Find 5: " + ll.find(5));

        ll.remove(5);

        ll.display();

        System.out.println("Find 5: " + ll.find(5));
    }
}
