package practise.leetCode;

public class Deadlock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {

        synchronized (lock1) {
            System.out.println("T1 acquired lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 waiting for lock2");

            synchronized (lock2) {
                System.out.println("T1 acquired lock2");
            }
        }
    }

    public void method2() {

        synchronized (lock2) {
            System.out.println("T2 acquired lock2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("T2 waiting for lock1");

            synchronized (lock1) {
                System.out.println("T2 acquired lock1");
            }
        }
    }

    public static void main(String[] args) {

        Deadlock obj = new Deadlock();

        Thread t1 = new Thread(() -> obj.method1());
        Thread t2 = new Thread(obj::method2);


        t1.start();
        t2.start();
    }
}