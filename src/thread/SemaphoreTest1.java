package thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Thread t1 = new Thread(new IncThread("Jayesh", sem));
        Thread t2 = new Thread(new IncThread("Rajesh", sem));
        Thread t3 = new Thread(new IncThread("Sukesh", sem));
        Thread t4 = new Thread(new IncThread("Mukesh", sem));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Resource5 {
    public static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    public IncThread (String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+" is waiting for permission");
            sem.acquire();
            System.out.println(name+" has got the permission");
            for (int i=0; i<4; i++) {
                System.out.println(name +" : "+ Resource5.count++);
                Thread.sleep(3000);
            }
            sem.release();
            System.out.println(name +" has released lock");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
