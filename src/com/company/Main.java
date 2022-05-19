package com.company;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //task1();
        task2();
    }

    static void task1() {
        HashMap<Integer, String> idAndNames = new HashMap<>();
        List<Integer> sortedList = new ArrayList<>();
        Integer sortedInt = 1;

        idAndNames.put(1, "Ivan");
        idAndNames.put(2, "Sergey");
        idAndNames.put(3, "Nikolay");
        idAndNames.put(4, "Piter");
        idAndNames.put(5, "Alex");
        idAndNames.put(6, "Evgeniy");
        idAndNames.put(7, "Mik");
        idAndNames.put(8, "Jon");
        idAndNames.put(9, "Alexander");
        idAndNames.put(10, "Sidor");
        idAndNames.entrySet().stream()
                .filter(x -> x.getValue().length() > 5)
                .filter(x -> x.getKey() % 3 == 0)
                .peek(x -> sortedList.add(x.getKey()))
                .forEach(System.out::println);
        for (Integer integer : sortedList)
            sortedInt *= integer;

        System.out.println(sortedInt);

    }

    static void task2() {
        Random r = new Random();
        List<Integer> myArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myArrayList.add(new Random().nextInt(100) + 1);
        }
        System.out.println(myArrayList);
        List<Integer> sortedList = new ArrayList<>();

        myArrayList.stream()
                .map(x -> {
                    if (x % 2 != 0) {
                        sortedList.add(x + 10);
                        return -1;
                    } else {
                        return x;
                    }
                })
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
        System.out.println(sortedList);

    }
}
