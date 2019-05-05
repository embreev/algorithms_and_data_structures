package ru.breev.recursion.backpack_and_items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    static Backpack bp;
    static List<Item> items;

    static int maxPrice(){
        for (Item item: items) {
            bp.addItem(item);
        }
        return bp.getPice();
    }

    public static void main(String[] args) {

        bp = new Backpack(15);

        items = new ArrayList<>();
        items.add(new Item("book", 12, 4));
        items.add(new Item("notepad", 2, 2));
        items.add(new Item("ruler", 1, 2));
        items.add(new Item("pen", 1, 1));
        items.add(new Item("diary", 4, 10));

        Collections.shuffle(items);
        System.out.println(maxPrice());
        bp.getItems();

    }

}
