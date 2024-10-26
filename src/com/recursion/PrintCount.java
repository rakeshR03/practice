package com.recursion;

public class PrintCount {

    public static void main(String[] args) {
        final Count c1 = new Count(0);
        Thread t1 = new Thread(() -> {
            try {
                c1.incrementCount();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(() -> {
            try {
                c1.incrementCount();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        Thread t3 = new Thread(() -> {
            try {
                c1.incrementCount();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        t1.start();
        t2.start();
        t3.start();
    }

}
class Count {
    volatile int count = 0;
    Count(int count) {
        this.count = count;
    }

    public void incrementCount() throws InterruptedException{
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                this.wait();
            }
        }

    }

}
