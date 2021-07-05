import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程的创建
 */


public class ThreadTest {
    private final static Lock lock = new ReentrantLock();
    private static int i = 0;
    public static void add(){
        lock.lock();
        try{
            i++;
        }finally {
            lock.unlock();
        }
    }

    private static class Plus implements Runnable{
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                add();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for (int k = 0; k < 10; k++) {
            threads[k]=new Thread(new Plus());
            threads[k].start();
        }
        for (int k = 0; k < 10; k++) {
            threads[k].join();
        }
        System.out.println(i);
    }
}
