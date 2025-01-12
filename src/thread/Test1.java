package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {
    public static void main(String[] args) {
        Helper helper = new Helper();
        Thread t1 = new Thread(helper);
        Thread t2 = new Thread(helper);
        Thread t3 = new Thread(helper);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Helper implements Runnable {

    AtomicInteger count = new AtomicInteger(0);

    public synchronized void display(){
        try {
            System.out.println("lock acquired by : "+Thread.currentThread().getName());
            System.out.println("count : "+count.incrementAndGet());
            Thread.sleep(3000);
            System.out.println("lock released by : "+Thread.currentThread().getName());
        } catch (Exception ex) {

        }
    }
    @Override
    public void run() {
        display();
    }
}