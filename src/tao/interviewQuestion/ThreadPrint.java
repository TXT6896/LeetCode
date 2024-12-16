package tao.interviewQuestion;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 编写两个线程交替打印数字和字母，线程1 依次打印1-10数字，线程2 依次打印 A-Z，线程2打印2轮后整体停止退出
 */
public class ThreadPrint {

    static AtomicInteger status = new AtomicInteger(0);
    static AtomicInteger count = new AtomicInteger(0);
    static Boolean flag = true;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            AtomicInteger num = new AtomicInteger(0);

            @Override
            public void run() {
                while (flag) {
                    synchronized (ThreadPrint.class) {
                        if (status.get() == 1 && flag) {
                            System.out.println("Thread 1 -> " + num.addAndGet(1));
                            if (num.get() == 10) num = new AtomicInteger(1);
                            status = new AtomicInteger(0);
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            char code = 'A';

            @Override
            public void run() {
                while (flag) {
                    synchronized (ThreadPrint.class) {
                        if (status.get() == 0) {
                            System.out.println("Thread 2 -> " + code);
                            if (code == 'Z') {
                                count.addAndGet(1);
                                code = 'A';
                            } else {
                                code++;
                            }
                            if (count.get() == 2) flag = false;
                                status = new AtomicInteger(1);
                        }
                    }
                }
            }
        }).start();


    }
}
