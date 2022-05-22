package model;

public class OldGenerics {
    private Object val;
    public OldGenerics(Object arg) {
        val = arg;
    }
    public String toString() {
        return "(" + val +")";
    }
    public Object getValue() {
        return val;
    }
    public <T> T test1 (T[] arr) {
    return arr[0];
    }
}
