package exam;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Task("task1"));
        executor.submit(new Task("task2"));
        executor.submit(new Task("task3"));
        executor.shutdown();
    }

}
class Task implements Runnable{
    private final String name;
    Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start " + name);
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
        }
        System.out.println("end task " + name);
    }
}
