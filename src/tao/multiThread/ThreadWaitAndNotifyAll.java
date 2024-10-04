package tao.multiThread;

/**
 * 线程等待唤醒
 */
public class ThreadWaitAndNotifyAll implements Runnable {

    // 模拟多个线程的共享变量
    private static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("线程" + Thread.currentThread().getName() + "获得锁，进入等待状态");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行最后部分结束");
        }
    }

    public static void main(String[] args) {
        ThreadWaitAndNotifyAll runnable = new ThreadWaitAndNotifyAll();
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName() + "获得锁，开始通知唤醒所有线程");
                // 唤醒其他线程
                object.notifyAll();
                // 调用完notifyAll()方法后，同步代码块中的其他代码，必须执行完后才能将对象锁释放，而不是调用了notifyAll()方法后立即释放。
                System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
            }
        });
        // 每次运行，线程0和线程1的顺序可能会不同，执行顺序由CPU决定
        thread0.start();
        thread1.start();
        try {
            // 加一个延时，让线程2一定在线程0和1之后执行，否则线程2中的notifyAll方法将无效
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
