package model;

public class NewGeneric<T> {
    private T val;

    public NewGeneric(T arg) {
        val = arg;
    }
    public String toString() {
        return "(" + val +")";
    }
    public T getValue() {
        return val;
    }
}
