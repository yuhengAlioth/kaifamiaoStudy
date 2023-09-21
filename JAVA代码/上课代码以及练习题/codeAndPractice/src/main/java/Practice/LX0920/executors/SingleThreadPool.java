package Practice.LX0920.executors;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0920.executors
 * @文件名称：SingleThreadPool
 * @代码功能：
 * @时间：2023/09/21/14:20
 */
public class SingleThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
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

    }
}

