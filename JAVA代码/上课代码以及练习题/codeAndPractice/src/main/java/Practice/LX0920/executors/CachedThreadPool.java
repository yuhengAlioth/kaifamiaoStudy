package Practice.LX0920.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0920
 * @文件名称：CachedThreadPool
 * @代码功能：使用`ThreadPoolExecutor`分别实现`Executors`的线程池
 * @时间：2023/09/21/14:16
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        // 使用`ThreadPoolExecutor`
        // 分别实现`Executors`的`newCachedThreadPool`、`FixedThreadPool`还有`SingleThreadExecutor`并测试。
        ExecutorService service = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                60,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()
        );
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();

    }
}

