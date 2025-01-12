package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        System.out.println("main thread starts");

        ResourceTest resource = new ResourceTest(5);

        Thread producerThread = new Thread(() -> resource.produceItem());
        Thread consumerThread = new Thread(() -> resource.consumeItem());

        consumerThread.start();
        producerThread.start();

        System.out.println("main thread ends");
    }
}

class ResourceTest {
    int size;
    Queue<Integer> queue = new LinkedList<>();

    int count = 0;

    public ResourceTest(int size) {
        this.size = size;
    }

    public synchronized void produceItem() {
        System.out.println("inside produceItem method : " + Thread.currentThread().getName());

        while (count < 10) {
            while (queue.size() < size) {
                System.out.println("adding item into the queue : " + count);
                queue.add(count++);
            }
            System.out.println("inside produceItem method, notifying all thread");
            notify();
            try {
                System.out.println("inside produceItem method, goes in waiting state - " + Thread.currentThread().getName());
                wait();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public synchronized void consumeItem() {
        System.out.println("inside consumeitem method : "+Thread.currentThread().getName());
        while(count < 10) {
            while (!queue.isEmpty()) {
                int ans = queue.poll();
                System.out.println("consuming from queue : "+ans);
            }
            System.out.println("consume Item method notifying all thread");
            notifyAll();
            try {
                System.out.println("consume item method goes in waiting state - " + Thread.currentThread().getName());
                wait();
            } catch (Exception ex) {
                System.out.println("consume ex : "+ ex);
            }

        }

    }
}
