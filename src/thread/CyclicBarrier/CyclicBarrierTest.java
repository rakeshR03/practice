package thread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        int numberOfSystems = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSystems, () -> {
            System.out.println("System startup completed");
        });

        Thread webServerThread = new Thread(new Subsystem("web server", 1000, barrier));
        Thread databaseThread = new Thread(new Subsystem("database", 1000, barrier));
        Thread cacheThread = new Thread(new Subsystem("cache", 1000, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();

        System.out.println("main ended");
    }
}

class Subsystem implements Runnable {
    private String name;
    private int initializationTime;

    private CyclicBarrier barrier;

    Subsystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + ": initialization started");
            Thread.sleep(initializationTime);
            System.out.println(name + ": initialization completed");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            System.out.println("exception : " + ex);
        }
    }
}
