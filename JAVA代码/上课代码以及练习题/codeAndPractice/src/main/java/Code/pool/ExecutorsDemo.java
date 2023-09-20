package Code.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.pool
 * @文件名称：ExecutorsDemo
 * @代码功能：可以缓存的线程池
 * @时间：2023/09/20/19:17
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        // 可缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
        service.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("执行任务");
        });
        service.shutdown(); // 关闭线程池

        ExecutorService service1 = Executors.newFixedThreadPool(10);
        // new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<Integer> submit = service1.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            return 1;
        });
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        service1.shutdown();
    }
}

