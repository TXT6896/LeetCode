package tao.multiThread;

public class InterruptDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    System.out.println("睡眠中断");
                    System.out.println(e.toString());
                }
                System.out.println("111");
            }
        });
        t.start();
        t.interrupt();
    }
}
