package com.company.model;

public class Test<F, S> {
    F obj1;
    S obj2;

    public Test(F obj1, S obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public F getObj1() {
        return obj1;
    }

    public void setObj1(F obj1) {
        this.obj1 = obj1;
    }

    public S getObj2() {
        return obj2;
    }

    public void setObj2(S obj2) {
        this.obj2 = obj2;
    }

    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

