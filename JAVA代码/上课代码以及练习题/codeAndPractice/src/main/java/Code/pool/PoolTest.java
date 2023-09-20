package Code.pool;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.pool
 * @文件名称：PoolTest
 * @代码功能：线程池
 * @时间：2023/09/20/14:01
 */
public class PoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, // 核心线程数量
                5, //最大线程数量
                2000, // 临时线程存活时间
                TimeUnit.MICROSECONDS, // 时间单位
                new ArrayBlockingQueue<>(5), // 任务队列
                new MyThreadFactory(), // 创建线程的工厂自定义工厂名字
//                new ThreadPoolExecutor.DiscardPolicy() // 任务饱和的时候的处理策略
//                Executors.defaultThreadFactory(), // 创建线程的工厂  默认方式创建
                new ThreadPoolExecutor.CallerRunsPolicy() // 任务饱和时的处理策略
        );

        for (int i = 0; i < 11; i++) {
            int num = i;
            // 先把前三个核心线程执行 剩下的七个放到任务队列 --> 5个放到任务队列 剩下2个 在创建两个临时线程
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " 执行任务-->" + num);
            });
        }
        // 立刻停止线程池，返回还没执行的任务
        List<Runnable> runnables = pool.shutdownNow();
        runnables.forEach(obj -> {
            new Thread(obj).start();
        });

    }

}

class MyThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"玉蘅的线程工厂");
    }
}

class PoolTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                500,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                // Executors.defaultThreadFactory  默认的工厂 pool-1-thread
                new MyThreadFactory2(), //
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 10; i++) {
            int num = i;
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "执行任务" + num);
            });
        }
        // 等任务全部执行（正在执行的任务以及正在队列中等待的任务）结束再关闭
        threadPoolExecutor.shutdown();
    }
}

class MyThreadFactory2 implements ThreadFactory {

    // 实现原子性修改变量的值
    AtomicInteger id = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "开发喵" + id.getAndIncrement() + "号员工");
    }
}