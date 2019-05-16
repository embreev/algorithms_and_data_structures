package ru.breev.recursion.backpack_and_items;

public class Item {

    String name;
    int weight;
    int price;

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
}
