package practise.leetCode;

public class PrintSequenceABCUsingThreads {

    private int turn = 0; // 0=A, 1=B, 2=C
    private final int repetitions = 5;

    public synchronized void printA() throws InterruptedException {
        for (int i = 0; i < repetitions; i++) {
            while (turn != 0) {
                wait();
            }
            System.out.print("A");
            turn = 1;
            notifyAll();
        }
    }

    public synchronized void printB() throws InterruptedException {
        for (int i = 0; i < repetitions; i++) {
            while (turn != 1) {
                wait();
            }
            System.out.print("B");
            turn = 2;
            notifyAll();
        }
    }

    public synchronized void printC() throws InterruptedException {
        for (int i = 0; i < repetitions; i++) {
            while (turn != 2) {
                wait();
            }
            System.out.print("C");
            turn = 0;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintSequenceABCUsingThreads printer = new PrintSequenceABCUsingThreads();
        Thread t1 = new Thread(() -> {
            try {
                printer.printA();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printer.printB();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                printer.printC();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}