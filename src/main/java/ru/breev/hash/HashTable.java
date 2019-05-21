package ru.breev.hash;

import java.util.LinkedList;
import java.util.List;

public class HashTable {

    static class Item {

        private int data;

        public Item(int data) {
            this.data = data;
        }

        public int getData() {
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
        } else if (hashArr[index].getClass().getName().equals(ru.breev.hash.HashTable.Item)) {
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

    private void display() {

    }


}