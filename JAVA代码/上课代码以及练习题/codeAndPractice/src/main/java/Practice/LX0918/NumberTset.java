package Practice.LX0918;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0918
 * @文件名称：Number
 * @代码功能：打印数字
 * @时间：2023/09/18/19:26
 */
public class NumberTset{

    // 创建两个线程，一个打印偶数，另一个打印奇数（范围从1到10）
    public static void main(String[] args) {
        NumberThread1 thread1 = new NumberThread1();
        NumberThread2 thread2 = new NumberThread2();
        thread1.start();
        thread2.start();

        // 创建两个线程，一个打印偶数，另一个打印奇数（范围从1到10）
        Thread t1 = new Thread() { // 匿名类 Thread
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println(i + "是奇数");
                    }
                }
            }
        };

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + "是偶数");
                }
            }
        });

        t2.start();
        try {
            t2.join(); // main 线程停下来（阻塞） 等待t2执行结束
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.start();

    }

}
class NumberThread1 extends Thread {
    @Override
    public void run(){
        int n = 10;
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0 ){
                System.out.println("偶数：" + i + "\t");
            }
        }
    }
}

class NumberThread2 extends Thread {
    @Override
    public void run(){
        int n = 10;
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 != 0 ){
                System.out.println("奇数：" + i + "\t");
            }
        }
    }
}