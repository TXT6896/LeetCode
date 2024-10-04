package tao.multiThread;

/**
 * 两线程交替打印字符
 */
public class ThreadPrint {

    private static int count = 0;

    public static void main(String[] args) {
        Object object = new Object();
        new Thread(() -> {
            while (count < 100) {
                synchronized (object){
                    if (count % 2 == 0 && count < 100) {
                        //System.out.println(count);
                        System.out.println('A');
                        count++;
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 100) {
                synchronized (object){
                    if (count % 2 == 1 && count < 100) {
                        //System.out.println(count);
                        System.out.println('B');
                        count++;
                    }
                }
            }
        }).start();
    }
}
