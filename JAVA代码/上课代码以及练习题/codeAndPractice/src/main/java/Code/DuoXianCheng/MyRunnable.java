package Code.DuoXianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：MyRunnable
 * @代码功能：
 * @时间：2023/09/18/19:13
 */
// 实现 Runnable 接口
public class MyRunnable implements Runnable {
    // 重写 run 方法
    @Override
    public void run() {
        // 这个线程要执行的任务
        System.out.println(Thread.currentThread().getName());
        System.out.println("My Runnable");
    }


    public static void main(String[] args) {
        System.out.println("main start");
        MyRunnable runnable = new MyRunnable();
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
        Thread thread = new Thread(runnable, "我自定义的线程");
        thread.start(); // 此时 开启新的线程
//        thread.start();
//        thread.run();
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });

        // new Thread(() -> System.out.println(Thread.currentThread().getName()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main end");
    }
}

