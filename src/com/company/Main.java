package com.company;

import static com.company.Test.a;

public class Main {

    public static void main(String[] args) {

        Multiplication m = new Multiplication();
        Division d = new Division();
        Addition a = new Addition();
        Subtraction s = new Subtraction();

        m.start();
        d.start();
        a.start();
        s.start();

        }

}






