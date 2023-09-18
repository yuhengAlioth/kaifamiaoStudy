package Code.DuoXianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：ThreadDemo
 * @代码功能：多线程
 * @时间：2023/09/18/15:16
 */
public class MyThread extends Thread {
    public  MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "运行第 " + i + "次数");
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("主线程main()");
        MyThread t = new MyThread("我写的子线程");
//        t.setName("子线程");
        t.getName();

        t.start(); // 启动线程

        t.setPriority(Thread.MAX_PRIORITY); // 1-10 min-max
        t.setPriority(Thread.MIN_PRIORITY); // 1-10 min-max
        int priority = t.getPriority();
        System.out.println("线程优先级：" + priority);

        t.interrupt(); //中断线程执行

        boolean interrupted = t.isInterrupted();
        System.out.println("线程中断状态：" + interrupted);

        boolean daemon = t.isDaemon();
        System.out.println("判断线程是否为是守护进程：" + daemon);

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "运行第 " + i + "次数");
        }
    }
}

