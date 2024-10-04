package tao.multiThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义多线程打印字符
 */
public class MultiThreadPrint extends Thread {
    static int index;
    static int maxCount;
    static AtomicInteger count;
    static ReentrantLock lock = new ReentrantLock(true);
    private int assign;
    private Runnable action;

    public MultiThreadPrint(int assign, Runnable action) {
        this.assign = assign;
        if (assign == index)
            this.assign = 0;
        this.action = action;
    }

    @Override
    public void run() {
        while (count.get() <= maxCount) {
            lock.lock();
            if (count.get() <= maxCount && count.get() % index == assign) {
                this.action.run();
                count.incrementAndGet();
            }
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        MultiThreadPrint.index = 5;//5个线深交替打字
        MultiThreadPrint.maxCount = 25;//每个线程打印25次
        MultiThreadPrint.count = new AtomicInteger(1);
        for (int i = 1; i <= 5; i++) {
            final int assign = i;
            MultiThreadPrint t = new MultiThreadPrint(assign, () -> {
                System.out.println((char) ('A' + assign - 1));
            });
            t.start();
        }
    }
}
