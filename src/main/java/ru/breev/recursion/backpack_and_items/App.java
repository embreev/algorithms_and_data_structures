package ru.breev.recursion.backpack_and_items;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    private static Backpack bp;
    private static List<Item> items;
    private static int maxPrice = 0;
    private static Item tmpItem;
    private static Set<Backpack> result = new HashSet<Backpack>();

    private static void shuffleItems(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            shuffleItems(length - 1);
            result.add(bp);
            rotate(length);
        }
    }

    private static void rotate(int length) {
        int pos = items.size() - length;
        tmpItem = items.get(pos);
        for (int i =  pos + 1; i < items.size(); i++) {
            items.set(i - 1, items.get(i));
        }
        items.set(items.size() - 1, tmpItem);

    }

    public static void main(String[] args) {

        bp = new Backpack(15);

        items = new ArrayList<>();
        items.add(new Item("book", 12, 4));
        items.add(new Item("notepad", 2, 2));
        items.add(new Item("ruler", 1, 2));
        items.add(new Item("pen", 1, 1));
        items.add(new Item("diary", 4, 10));

        shuffleItems(items.size());
        System.out.println(bp);

    }



}
