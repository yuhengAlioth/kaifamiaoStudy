package Code.DuoXianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：SleepTest
 * @代码功能：
 * @时间：2023/09/18/19:22
 */
public class SleepTest {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "运行" + i + "次");
            }
        }, "zyj");
        System.out.println(thread.isAlive());
        thread.start();
        Thread.currentThread().setName("lgw");
        System.out.println(thread.isAlive()); // 线程的状态 如果线程启动了还在执行任务 那么就是true
        for (int i = 0; i < 10; i ++) {
            System.out.println(Thread.currentThread().getName() + "运行" + i + "次");
            try {
                Thread.sleep(2000);
                System.out.println(thread.isAlive());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("main end");
    }
}

