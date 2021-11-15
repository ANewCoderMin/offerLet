package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Min
 * @create 2021-04-21 20:45
 */
public class CallablePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableThread callableThread = new CallableThread<>();
        FutureTask<String> futureTask = new FutureTask<String>(callableThread);
        new Thread(futureTask).start();
        System.out.println("========主线程在做其他事=======");
        if(!futureTask.isDone()){
            System.out.println("========还没做完主线程继续做其他事========");
        }
        System.out.println(futureTask.get());
        CallableThread.countDownLatch.await();
    }


}
class CallableThread<String> implements Callable{

    public static  CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    public Object call() throws Exception {
        System.out.println("Thread:" + Thread.currentThread().getName());
        Thread.sleep(1000*10);
        countDownLatch.countDown();
        return "Callable return result.";
    }
}