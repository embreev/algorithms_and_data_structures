package ru.breev.linked_list;

public class LinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;


    @Override
    public void insert(E value) {
        Entry<E> newElement = new EntryImpl<>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        size++;
    }

    @Override
    public E removeElement() {
        if ( isEmpty() ) {
            return null;
        }

        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();

        size--;
        return removedElement.getValue();
    }

    @Override
    public boolean remove(E value) {
        Entry<E> currentElement = firstElement;
        Entry<E> previousElement = null;
        while ( currentElement != null ) {
            if ( currentElement.getValue().equals(value) ) {
                break;
            }

            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }

        if (currentElement == null) {
            return false;
        }

        if (currentElement == firstElement) {
            firstElement = firstElement.getNext();
        }
        else {
            previousElement.setNext(currentElement.getNext());
        }

        size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean find(E value) {
        return doFind(value) !=null;
    }

    private Entry<E> doFind(E value) {
        Entry<E> currentElement = firstElement;
        while ( currentElement != null ) {
            if ( currentElement.getValue().equals(value) ) {
                return currentElement;
            }
            currentElement = currentElement.getNext();
        }

        return null;
    }

    @Override
    public void display() {
        System.out.println("------");
        System.out.println(this.getClass().getSimpleName());

        Entry<E> current = firstElement;
        while ( current != null ) {
            System.out.println(current);
            current = current.getNext();
        }

        System.out.println("------");
    }

    @Override
    public E getFirstElement() {
        return firstElement.getValue();
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }
}
