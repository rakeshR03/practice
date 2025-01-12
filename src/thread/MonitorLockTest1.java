package thread;

public class MonitorLockTest1 {
    public static void main(String[] args) {
        System.out.println("Main method start");
        SharedResourceTest resource = new SharedResourceTest();

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                resource.produceItem();
            } catch (Exception ex) {
                System.out.println("ex");
            }
        }
        );
        Thread consumerThread = new Thread(() -> resource.consumeItem());

        producerThread.start();
        consumerThread.start();
        System.out.println("Main method end");
    }
}

class SharedResourceTest {
    boolean itemAvailable = false;

    public synchronized void produceItem() {
        System.out.println("inside produceItem method - " + Thread.currentThread().getName());
        itemAvailable = true;
        System.out.println("invoking all other thread from produceItem method");
        notify();
    }

    public synchronized void consumeItem() {
        System.out.println("inside consumeItem method - " + Thread.currentThread().getName());
        while(!itemAvailable) {
            try {
                System.out.println("Thread : "+Thread.currentThread().getName()+", is going into waiting state");
                wait();
            } catch (Exception ex) {
                System.out.println("consumeItem exception : "+ ex);
            }
        }
        System.out.println("Thread : "+Thread.currentThread().getName()+ ", is consuming resource");
        itemAvailable = false;
    }
}
