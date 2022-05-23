package com.company;

import com.company.model.Test;

public class Main {

    public static void main(String[] args) {
        Test<String, Integer> obj1 =
                new Test<String, Integer>("Ivan", 45);

        System.out.println("Test" + obj1.hashCode());

        Test<String, String> obj2 = new Test<String, String>("Ivan", "45");

        System.out.println("Test" + obj2.hashCode());

        obj1.print();

        obj2.print();


    }
    }

