package tao.multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池默认拒绝策略带来的问题测试
 */
public class ThreadPoolPolicyDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                2,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadFactory() {
                    AtomicInteger integer = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("My-Thread-" + integer.getAndAdd(1));
                        return thread;
                    }
                }, new ThreadPoolExecutor.AbortPolicy());

        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            System.out.println("第 " + i + " 个任务提交");
            try {
                Future<Integer> future = poolExecutor.submit(() -> {
                    System.out.println("任务 " + finalI + " 执行 执行线程 " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("任务 " + finalI + " 执行完毕 执行线程 " + Thread.currentThread().getName());
                    return finalI * 10;
                });
                futureList.add(future);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("任务提交完成");
        for (Future future : futureList) {
            System.out.println("任务执行返回" + future.get(10, TimeUnit.SECONDS));
        }
        System.out.println("彻底结束");
    }
}
