package practise.leetCode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        java.util.concurrent.Callable<Integer> task = () -> {
            Thread.sleep(5000);
            return 100;
        };
        Future<Integer> future = executor.submit(task);
        // printed by main thread
        System.out.println("Doing other work...");
        // by worker thread prints output after 5 seconds as it will be sleeping
        System.out.println(future.get());
        executor.shutdown();


        Callable<Integer> task1 = () -> {
            System.out.println("Running in: " + Thread.currentThread().getName());
            return 100;
        };

        final Integer[] result = new Integer[1];

        Thread t = new Thread(() -> {
            try {
                result[0] = task1.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t.start();
        t.join();

        System.out.println("Result: " + result[0]);
    }
}