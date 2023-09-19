package Practice.LX0918;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0918
 * @文件名称：Interrupt
 * @代码功能：中断线程
 * @时间：2023/09/18/19:27
 */
public class InterruptTest {

    // 创建一个线程循环对一个数做加一操作，5秒后在主线程中中断线程并在主线程（main）输出结果
    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        thread.start();
        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(thread.getCount());
    }
}
class InterruptThread extends Thread {
    private long count = 0;

    @Override
    public void run() {

        while (true) { //查看线程中断状态
            count++;
            if (Thread.currentThread().isInterrupted()){
                // 线程被中断，退出循环
                break;
            }
        }
    }

    public long getCount() {
        return count;
    }

}
