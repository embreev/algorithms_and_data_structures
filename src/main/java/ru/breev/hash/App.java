package ru.breev.hash;

public class App {

    public static void main(String[] args) {

        HashTable ht = new HashTable(10);

        ht.insert(new HashTable.Item(301));
        ht.insert(new HashTable.Item(102));
        ht.insert(new HashTable.Item(102));
        ht.insert(new HashTable.Item(505));
        ht.insert(new HashTable.Item(203));
        ht.insert(new HashTable.Item(301));
        ht.insert(new HashTable.Item(434));
        ht.insert(new HashTable.Item(605));

        ht.display();
    }
}
