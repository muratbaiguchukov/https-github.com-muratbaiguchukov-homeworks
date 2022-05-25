package com.company;

import static com.company.Test.a;

public class Multiplication extends Thread{


    @Override
    public void run () {
       System.out.println(a*2);
    }
}
