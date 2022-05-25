package com.company;

import static com.company.Test.a;

public class Addition extends Thread{


    @Override
    public void run() {
       System.out.println(a+2);
    }
}
