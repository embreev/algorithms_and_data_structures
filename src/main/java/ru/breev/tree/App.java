package ru.breev.tree;

import java.util.Random;

public class App {

    static int MAX_LEVEL_TREE = 3;
    static int BOUND_TREES = 20;
    static int RANGE = 100;

    static int balancedTreeCount = 0;
    static boolean printTree = false;

    public static void main(String[] args) {

        for (int i = 0; i < BOUND_TREES; i++) {
            Tree<Integer> tree = new TreeImpl<>(MAX_LEVEL_TREE);

            for (int j = 0; j < (int) (Math.pow(2, MAX_LEVEL_TREE) - 1); j++) {
                tree.add(new Random().nextInt(RANGE * 2 + 1) - RANGE);
            }
            if (tree.isBalanced()) {
                balancedTreeCount++;
                if (!printTree) {
                    printTree = true;
                    tree.display();
                }
            }
        }

        System.out.println("======");
        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (BOUND_TREES * 1.0)) * 100) + "%");

    }
}
