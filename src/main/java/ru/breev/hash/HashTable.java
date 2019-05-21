package ru.breev.hash;

import java.util.LinkedList;
import java.util.List;

public class HashTable {

    static class Item {

        private int data;

        Item(int data) {
            this.data = data;
        }

        int getData() {
            return data;
        }
    }

    private Object[] hashArr;
    private int maxSize;
    private int size;

    public HashTable(int capacity) {
        this.maxSize = capacity;
        hashArr = new Object[capacity];
    }

    private int hashFunc(int key) {
        return key % hashArr.length;
    }

    protected boolean insert(Item item) {
        if (size == maxSize) {
            return false;
        }

        int index = hashFunc(item.getData());
        List list;

        if (hashArr[index] == null) {
            hashArr[index] = item;
            return true;
        } else if (hashArr[index] instanceof HashTable.Item) {
            list = new LinkedList();
            list.add(hashArr[index]);
            list.add(item);
            hashArr[index] = list;
            return true;
        } else {
            list = new LinkedList((List) hashArr[index]);
            list.add(item);
            hashArr[index] = list;
            return true;
        }
    }

    protected void display() {
        for (int i = 0; i < hashArr.length; i++) {
                System.out.println(hashArr[i]);
        }
    }


}