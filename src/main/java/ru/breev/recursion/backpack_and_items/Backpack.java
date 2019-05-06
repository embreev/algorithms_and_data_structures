package ru.breev.recursion.backpack_and_items;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int capacity;
    private int count;
    private int price;
    private List<Item> backpack = new ArrayList<>();

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (item.weight <= capacity) {
            backpack.add(item);
            price = price + item.price;
            capacity = capacity - item.weight;
            count++;
            return true;
        } else {
            return false;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return count;
    }

    public int getPice() {
        return price;
    }

}
