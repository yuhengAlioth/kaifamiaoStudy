package Code.XianCheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.XianCheng
 * @文件名称：MovieTheater
 * @代码功能：
 * @时间：2023/09/19/15:07
 */
public class MovieTheater {
    private int ticket = 100;
    // 创建锁对象
    private Lock lock = new ReentrantLock();

    public void sell() {
        lock.lock(); // 加锁
        while (ticket > 0) {
            System.out.println(ticket + "已经售出");
            ticket--;
            // 出票的过程
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        lock.unlock(); // 释放锁
    }
}
class MovieTest {

    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater();
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                movieTheater.sell();
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
            System.out.println("main end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
