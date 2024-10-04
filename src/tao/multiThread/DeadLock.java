package tao.multiThread;

import java.text.ParseException;

/**
 * 死锁实现
 */
public class DeadLock {

    private static Object o = new Object();

    public  static void sou() throws InterruptedException {
        synchronized (o){
            Thread.sleep(1000);
            System.out.println("1111");
            Demo2.out();
        }
    }

    public static void main(String[] args) throws ParseException {
        new Thread(()->{
            try {
                sou();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                Demo2.out();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static class Demo2{
        private static Object o = new Object();
        public static void out() throws InterruptedException {
            synchronized (o){
                System.out.println("2222");
                DeadLock.sou();
            }
        }
    }
}
