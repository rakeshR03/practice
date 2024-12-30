package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) {
        Resource resource = new Resource(new LinkedList<>(), 3);
        ProducerTask producerTask = new ProducerTask(resource);
        ConsumerTask consumerTask = new ConsumerTask(resource);
        Thread thread1 = new Thread(producerTask);
        Thread thread2 = new Thread(consumerTask);
        thread1.start();
        thread2.start();
    }
}
class Resource {
    Queue<Integer> buffer;
    int bufferSize;

    Resource(Queue<Integer> buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
    }

    synchronized void produce(int i) {
        System.out.println("produce method :: start");
        while(buffer.size() >= bufferSize) {
            try {
                System.out.println("producer will wait");
                wait();
            } catch (Exception exception) {
                System.out.println("Exception produce");
            }
        }
        System.out.println("buffer added : " + i);
        buffer.add(i);
        // notify the consumers, buffer is ready to consume
        notify();
        System.out.println("produce method :: end");
    }

    synchronized void consume() {
        System.out.println("consume method :: start");
        while (buffer.isEmpty()) {
            try {
                System.out.println("consumer will wait");
                wait();
            } catch (Exception e) {
                System.out.println("Exception consume");
            }
        }
        System.out.println("buffer consumed : " + buffer.peek());
        buffer.poll();
        // notify producer, buffer is ready to be produced
        notify();
        System.out.println("consume method :: end");
    }
}

class ProducerTask implements Runnable {
    Resource resource;

    ProducerTask(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        System.out.println("producerTask method :: start");
        for (int i=0; i<10; i++) {
            resource.produce(i);
        }
        System.out.println("producerTask method :: end");
    }
}

class ConsumerTask implements Runnable {
    Resource resource;

    ConsumerTask(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("consumerTask method :: start");
        for (int i=0; i<10; i++) {
            resource.consume();
        }
        System.out.println("consumerTask method :: end");
    }
}
