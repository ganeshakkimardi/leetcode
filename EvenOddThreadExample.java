package practise.leetCode;

class NumberPrinter {
    int i = 1;
    int MAX = 10;

    public synchronized void printOdd() {
        try {
            while (i <= MAX) {
                while (i % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (i <= MAX) {
                    System.out.println("Odd : " + i++);
                    notifyAll();
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void printEven() {
        try {
            while (i <= MAX) {
                while (i % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (i <= MAX) {
                    System.out.println("Even : " + i++);
                    notifyAll();
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

public class EvenOddThreadExample {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread oddPrinter = new Thread(printer::printOdd);
        Thread evenPrinter = new Thread(printer::printEven);

        oddPrinter.start();
        evenPrinter.start();
    }
}
