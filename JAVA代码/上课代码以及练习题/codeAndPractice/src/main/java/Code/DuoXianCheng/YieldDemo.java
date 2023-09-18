package Code.DuoXianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：YieldDemo
 * @代码功能：
 * @时间：2023/09/18/19:23
 */
public class YieldDemo {
    public static void main(String[] args) {
//        Runnable run = () -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(i);
//            }
//        };

        Thread t1 = new Thread(new MyRunnable2(), "第一个线程");
        System.out.println(t1.getState());
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName());
                        notify();
                    }
                }
            }
        }, "第二个线程");
        t1.start();
        System.out.println(t1.getState());

        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(t2.getState()); // TERMINATED
        System.out.println(t1.getState());
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("被唤醒");
            }
        }
    }
}

