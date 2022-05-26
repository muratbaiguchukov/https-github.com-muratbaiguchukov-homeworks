package model;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainThread {

    public static volatile int PLACE = 1;
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        task5();
    }

    static void task1() {

        System.out.println("start thread");
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("end thread");

        System.out.println("runnable start");
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread runnableThread = new Thread(myThreadRunnable);
        runnableThread.start();
        System.out.println("runnable end");

        Thread anonymClass = new Thread(
                () -> {
                    System.out.println("Anonym class");
                }

        );

        anonymClass.start();

    }

    static void task2() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                Document another = new Document("another");
                another.print();

            });
            thread.start();
            Document my = new Document("me");
            my.print();
        }
    }


    static void task3() {
        String[] people = new String[20];
        for (int i = 0; i < 20; i++) {
            people[i] = "Name " + (i + 1);
        }
        Thread p1 = new Thread(new Queue(0, 10, people));
        p1.setName("people 1");
        Thread p2 = new Thread(new Queue(10, 20, people));
        p2.setName("people 2");
        p1.start();
        p2.start();
    }

    static void task4(){
        Thread raatbekBook = new Thread(new PrinterRequest(5, "raat", null));
        Thread koshoyBook = new Thread(new PrinterRequest(5, "koshoy", raatbekBook));
        Thread muratBook = new Thread(new PrinterRequest(5, "murat", koshoyBook));

        raatbekBook.start();
        koshoyBook.start();
        muratBook.start();


    }

    static void task5(){
        Thread r1 = new Thread(new Racer());
        r1.setName("r1");
        Thread r2 = new Thread(new Racer());
        r2.setName("r2");
        Thread r3 = new Thread(new Racer());
        r3.setName("r3");
        Thread r4 = new Thread(new Racer());
        r4.setName("r4");
        Thread r5 = new Thread(new Racer());
        r5.setName("r5");
        r1.setPriority(10);
        r3.setPriority(1);

        r1.start();
        try {
            r1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r2.start();
        r3.start();
        r4.start();
        r5.start();
    }
}

class Racer implements Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ": " + MainThread.PLACE++);
    }
}

class Queue implements Runnable{
    private int start;
    private int end;

    private String[] people;

    public Queue(int start, int end, String[] people) {
        this.start = start;
        this.end = end;
        this.people = people;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++){
            System.out.println(Thread.currentThread().getName() + ": " + people[i]);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }}

class PrinterRequest implements Runnable {
    private int copyAmount;

    private String text;

    private Thread waitFor;

    public PrinterRequest(int copyAmount, String text, Thread waitFor) {
        this.copyAmount = copyAmount;
        this.text = text;
        this.waitFor = waitFor;
    }


    @Override
    public void run() {
        try {
            if(waitFor != null)
            waitFor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        Printer.print(copyAmount, text);
    }}

class Printer {
    static void print(int copyAmount, String text) {
        for (int i = 0; i < copyAmount; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println(text);

        }
    }
}



