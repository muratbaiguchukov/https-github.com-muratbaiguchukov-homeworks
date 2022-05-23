package model;

import java.util.ArrayList;
import java.util.List;

public class MainGeneric {
    public static void main(String[] args) {
        //task2();
        System.out.println(greatest(12,23,123));
    }

    public static <T extends Comparable<T>>T greatest(T x, T y, T z){
        T max = x; //Пока что, Х максимальное
        if (y.compareTo(max) > 0){
            max = y; // Значит Y больше X
        }
        if (z.compareTo(max) > 0) {
            max = z; // Значит Z больше всех
        }        return max;
    }

    static void task1() {

        OldGenerics number = new OldGenerics(1);
        OldGenerics stringVar = new OldGenerics("String");
        OldGenerics catVar = new OldGenerics(new Cat("tom", 12));
        OldGenerics numberDouble = new OldGenerics(1.1);// Здесь мы ожидали Integer, но передали Double и не видим ошибки
        //Object cat = new Cat();
        //Cat cat2 = (Cat) cat();

        NewGeneric<Integer> numberNew = new NewGeneric<>(1);
        NewGeneric<String> stringNew = new NewGeneric<>("String");
        NewGeneric<Cat> catNew = new NewGeneric<Cat>(new Cat("tom", 12));
        List<Integer> aaa = new ArrayList<>();
//    NewGeneric<Double> numberDouble = new NewGeneric<>(1);// А здесь мы сразу получили ошибку, что передаем не тот тип

        System.out.println(number.getValue());
        System.out.println(stringVar.getValue());
        System.out.println(catVar.getValue());
        System.out.println("generics");
        System.out.println(numberNew.getValue());
        System.out.println(stringNew.getValue());
        System.out.println(catNew.getValue());
    }

    static void task2() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.1, 3.1, 4.1, 5.1};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        printArr(intArray);
        printArr(doubleArray);
        printArr(charArray);

    }

    static void task3() {
        Integer[] intArr = {1,3,4,5,65};
        Character[] charArr = {'C','B'};
        Integer first = getFirst(intArr); // возвращает первый элемент маасива
        Character firstChar = getFirst(charArr);
        System.out.println(getFirst(intArr)); // выводит на консоль
        getFirst(intArr);
    }

    static <T> Integer task3ChyngyzVersion() {
        Integer[] intArr = {1,3,4,5,6};
        return intArr[0];
    }

    static <T> T getFirst(T[] arr) {
        return arr[0];

    }


    static <T> void printArr(T[] arr) {
        for (T element : arr) {
            System.out.printf("%s", element);
        }
        System.out.println();

    }
}
