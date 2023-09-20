package Code.pool;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.pool
 * @文件名称：Scheduled
 * @代码功能：
 * @时间：2023/09/20/19:22
 */
public class Scheduled {
    public static void main(String[] args) {
        // start() 启动线程 执行任务
        // execute() 执行Runnable任务
        // submit() 执行Callable任务

        // schedule() 执行 Runnable 和 Callable 都可以 只执行一次 delay + unit 时间之后执行一次这个任务
        // scheduleAtFixedRate 执行 Runnable 任务 延迟 initialDelay + unit 之后执行一次，然后每隔 period + unit执行一次
        // scheduleWithFixedDelay 执行 Runnable 任务 延迟 initialDelay + unit之后执行一次， 等待上一个线程执行结束 下一个线程在delay时间之后再开始执行
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        System.out.println(LocalTime.now());
        // 只执行一次 延迟 delay + unit 之后执行一次
//        ScheduledFuture<?> schedule = service.schedule(() -> {
//            System.out.println(Thread.currentThread().getName() + LocalTime.now() + "执行了");
//        }, 2, TimeUnit.SECONDS);
//        ScheduledFuture<Integer> future = service.schedule(() -> {
//            System.out.println(Thread.currentThread().getName() + LocalTime.now() + "执行了");
//            return 1;
//        }, 2, TimeUnit.SECONDS);
//        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(() -> {
//            System.out.println(Thread.currentThread().getName() + LocalTime.now() + "执行了");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, 2, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = service.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + LocalTime.now() + "执行了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 2, 1, TimeUnit.SECONDS);
        try {
            System.out.println(scheduledFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

