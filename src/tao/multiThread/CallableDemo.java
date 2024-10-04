package tao.multiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程实现方式之Callable
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                Thread.sleep(1000);
            }

            return "000";
        });
        new Thread(futureTask,"callable").start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            Thread.sleep(500);
        }
        System.out.println(futureTask.get());
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
