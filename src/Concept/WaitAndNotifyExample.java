package Concept;

public class WaitAndNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        final Processor processor = new Processor();

        Thread thread1 = new Thread(() -> {
            try{
                processor.produce();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}

class Processor {

    Processor(){}
    public void produce() throws InterruptedException{
        System.out.println(Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("Producer thread running" + Thread.currentThread().getName());
            wait();
            System.out.println("resumed" + Thread.currentThread().getName());
        }

    }
    public void consume() throws InterruptedException{
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("waiting for a key" + Thread.currentThread().getName());
            notify();
            System.out.println("notify called" + Thread.currentThread().getName());
        }
    }
}
