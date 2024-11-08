package Multithreading;

public class MonitorLock {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
class SharedResource {
    boolean flag = false;
    synchronized void addResource() {
        System.out.println("addResource method start");
        flag = true;
        System.out.println("addResource method end");
        notify();
    }
    synchronized void deleteResource() {
        System.out.println("deleteResource method start");
        while (!flag) {
            try {
                System.out.println("deleteResource is waiting");
                wait(1000);
            } catch (Exception e) {
                System.out.println("wait exception");
            }
        }
        flag = false;
        System.out.println("deleteResource method end");
    }
}

class Producer implements Runnable{
    SharedResource sharedResource;
    Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        System.out.println("producer run method : start");
        try{
            System.out.println("producer going to sleep");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception");
        }

        sharedResource.addResource();
        System.out.println("producer run method : end");
    }
}

class Consumer implements Runnable{
    SharedResource sharedResource;
    Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        System.out.println("consumer run method : start");
        sharedResource.deleteResource();
        System.out.println("consumer run method : end");
    }
}