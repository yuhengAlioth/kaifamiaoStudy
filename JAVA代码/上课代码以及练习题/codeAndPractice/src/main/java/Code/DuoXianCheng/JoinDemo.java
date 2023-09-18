package Code.DuoXianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：JoinDemo
 * @代码功能：
 * @时间：2023/09/18/19:20
 */
public class JoinDemo {
    public static void main(String[] args) {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "运行" + i + "次数");
                }
            }
        };
        Thread t1 = new Thread(run, "第一个线程");
        Thread t2 = new Thread(run, "第二个线程");
        Thread t3 = new Thread(run, "第三个线程");

        t1.start();
        try {
            // 等待 10 毫秒，如果没有停止，就不等了 让其他线程一起执行
            t1.join(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t1.isAlive());
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t2.isAlive());
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

