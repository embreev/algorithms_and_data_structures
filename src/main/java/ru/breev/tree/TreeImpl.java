package ru.breev.tree;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int maxLevel;

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean add(E value) {

        Node node = new Node<>(value);

        if (isEmpty()) {
            root = node;
            return true;
        } else {
            Node<E> current = root;
            Node<E> previous = root;

//            if (current != null) {
//                return false;//Found duplicate
//            }

            int level = previous.getLevel() + 1;
            if (level > maxLevel) {
                return false;
            }

            while (true) {
                previous = current;
                if (value.compareTo(current.getValue()) < 0) {
                    current = current.leftChild;
                    if (current == null) {
                        previous.leftChild = node;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        previous.rightChild = node;
                        return true;
                    }
                }
            }
        }
//        return false;
    }

    @Override
    public boolean remove(E value) {

        Node<E> current = root;
        Node<E> previous = root;

        boolean isLeftChild = true;

        while (value != current.getValue()) {
            previous = current;

            if (value.compareTo(current.getValue()) < 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                previous.leftChild = null;
            } else {
                previous.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                previous.leftChild = current.leftChild;
            } else {
                previous.rightChild = current.rightChild;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                previous.rightChild = current.rightChild;
            } else {
                previous.leftChild = current.leftChild;
            }
        } else {
            Node successor = getSuccesor(current);
            if (current == root){
                root = successor;
            }else if(isLeftChild){
                previous.leftChild = successor;
            }else {
                previous.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
    }

    public Node getSuccesor(Node node){
        Node<E> successorParent = node;
        Node<E> successor = node;
        Node<E> current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }


    @Override
    public boolean find(E value) {
        Node<E> current = root;

        while (current != null) {
            if (value == current.getValue()) {
                break;
            }
            if (value.compareTo(current.getValue()) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (current == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("_");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}