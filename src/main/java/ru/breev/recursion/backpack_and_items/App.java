package ru.breev.recursion.backpack_and_items;

public class App {

    static Backpack bp = new Backpack(15);

    static Item book = new Item("book", 12, 4);
    static Item notepad = new Item("notepad", 2, 2);
    static Item ruler = new Item("ruler", 1, 2);
    static Item pen = new Item("pen", 1, 1);
    static Item diary = new Item("diary", 4, 10);

    public static void main(String[] args) {
        bp.addItem(book);
        bp.addItem(notepad);
        bp.addItem(ruler);
        bp.addItem(pen);
        bp.addItem(diary);

        System.out.println("сapacity = " + bp.getCapacity());
        bp.getItems();
    }

}
