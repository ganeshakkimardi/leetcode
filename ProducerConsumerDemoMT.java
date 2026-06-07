package practise.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemoMT {

    static class ProducerConsumer {

        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity = 5;

        public synchronized void produce(int value)
                throws InterruptedException {

            while (queue.size() == capacity) {
                System.out.println("Queue is full. Producer waiting...");
                wait();
            }
            queue.add(value);
            System.out.println("Produced: " + value);
            notifyAll();
        }

        public synchronized int consume() throws InterruptedException {

            while (queue.isEmpty()) {
                System.out.println("Queue is empty. Consumer waiting...");
                wait();
            }
            int value = queue.poll();
            System.out.println("Consumed: " + value);

            notifyAll();
            return value;
        }
    }

    public static void main(String[] args) {

        ProducerConsumer pc = new ProducerConsumer();
        Thread producer = new Thread(() -> {
            int value = 1;

            try {
                while (true) {
                    pc.produce(value++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    pc.consume();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}