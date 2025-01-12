package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest2 {
    public static void main(String[] args) {
        Resource2 resource = new Resource2(3);

        Thread producerThread = new Thread(() -> {
           for (int i=0; i<6; i++) {
               resource.produceItem(i);
           }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i=0; i<6; i++) {
                System.out.println("consumed : "+resource.consumeItem());
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

class Resource2 {
    int size;
    Queue<Integer> queue;

    public Resource2(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public synchronized void produceItem(int i){
        System.out.println("inside produce item method : " + Thread.currentThread().getName());
        while(queue.size() >= size) {
            try {
                System.out.println("producer is waiting");
                wait();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        System.out.println("producer is producing : "+i);
        queue.add(i);
        notifyAll();
    }

    public synchronized int consumeItem() {
        System.out.println("inside consume item method : "+Thread.currentThread().getName());
        while(queue.isEmpty()) {
            try {
                System.out.println("consumer is waiting");
                wait();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        System.out.println("consumer is consuming");
        int del = queue.poll();
        notifyAll();
        return del;
    }

}
