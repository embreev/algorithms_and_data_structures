package ru.breev.linked_list;

import java.util.Objects;

public class EntryImpl<T> implements Entry<T> {

    private final T value;
    private Entry<T> next;

    public EntryImpl(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public Entry<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Entry<T> nextElement) {
        this.next = nextElement;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryImpl<?> entry = (EntryImpl<?>) o;
        return Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
