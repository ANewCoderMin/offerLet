package thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Min
 * @create 2021-04-21 21:36
 */
public class ThreadPoolPractice1 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        executorService.execute(()->{
            System.out.println("线程池运行的线程：" + Thread.currentThread().getName());
        });
    }

}
