package ru.breev.hash;

public class App {

    public static void main(String[] args) {

        HashTable ht = new HashTable(10);

        ht.insert(new HashTable.Item(100));
        ht.insert(new HashTable.Item(150));
        ht.insert(new HashTable.Item(130));
        ht.insert(new HashTable.Item(105));
        ht.insert(new HashTable.Item(200));
        ht.insert(new HashTable.Item(100));
        ht.insert(new HashTable.Item(130));
        ht.insert(new HashTable.Item(100));

    }
}
