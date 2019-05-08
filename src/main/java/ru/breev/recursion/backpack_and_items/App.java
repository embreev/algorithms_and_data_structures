package ru.breev.recursion.backpack_and_items;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static Backpack bp;
    private static List<Item> items;
    private static List<Item> tmpItems;
    private static List<Item> bestItems;
    private static int maxPrice = 0;
    private static Item tmpItem;

    private static void shuffleItems(int length) {
        if (length == 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            shuffleItems(length - 1);
            add();
            if (bp.getPice() > maxPrice) {
                maxPrice = bp.getPice();
            }
            rotate(length);
        }
    }

    private static void display() {
        System.out.println(maxPrice);
        for (Item item : bestItems) {
            System.out.print(item.getName() + ", ");
        }
    }

    private static void add() {
        bestItems = new ArrayList<>(tmpItems);
        for (int i = 0; i < bestItems.size(); i++) {
            if (!bp.addItem(bestItems.get(i))) bestItems.remove(i);
        }
    }

    private static void rotate(int length) {
        int pos = tmpItems.size() - length;
        tmpItem = items.get(pos);
        for (int i =  pos + 1; i < tmpItems.size(); i++) {
            tmpItems.set(i - 1, tmpItems.get(i));
        }
        tmpItems.set(items.size() - 1, tmpItem);

    }

    public static void main(String[] args) {

        bp = new Backpack(15);

        items = new ArrayList<>();
        items.add(new Item("book", 12, 4));
        items.add(new Item("notepad", 2, 2));
        items.add(new Item("ruler", 1, 2));
        items.add(new Item("pen", 1, 1));
        items.add(new Item("diary", 4, 10));

        tmpItems = new ArrayList<>(items);

        shuffleItems(items.size());

        display();


    }



}
