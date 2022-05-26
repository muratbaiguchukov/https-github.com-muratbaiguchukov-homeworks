package model;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("I'm thread");
    }
}
