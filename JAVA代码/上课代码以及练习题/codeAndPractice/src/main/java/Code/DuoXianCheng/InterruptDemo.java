package Code.DuoXianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：InterruptDemo
 * @代码功能：
 * @时间：2023/09/18/19:19
 */
public class InterruptDemo {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().getName() + "运行" + i + "次数");
                }
            }
        };
        Thread t1 = new Thread(run, "第一个线程");
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i > 10) {
                    t1.interrupt();
                }
                System.out.println(Thread.currentThread().getName() + "运行" + i + "次数");
            }
        }, "第二个线程");
        try {
            t1.interrupt();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}

