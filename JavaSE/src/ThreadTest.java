/**
 * 多线程的创建
 */



class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread p = new MyThread();
        p.start();
    }
}
