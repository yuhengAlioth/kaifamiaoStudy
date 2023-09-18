package Code.DuoXianCheng;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuoXianCheng
 * @文件名称：MyCallable
 * @代码功能：
 * @时间：2023/09/18/19:14
 */
// 实现Callable接口
public class MyCallable implements Callable<Integer> {
    // 重写call方法
    @Override
    public Integer call() throws Exception {
        // Callable对象要执行的任务
        int sum = 0;
        for (int i = 1; i < 1001; i++) {
            System.out.println(Thread.currentThread().getName());
            sum += i;
        }
        return sum;
    }


    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 1; i < 101; i++) {
                sum += i;
            }
            return sum;
        });
        Thread thread = new Thread(futureTask);
        thread.setName("С");
        thread.start(); // ߳
        for (int i = 0; i < 10000; i++) {
            System.out.println("main" + i + "");
        }
//        try {
//            System.out.println(futureTask.get());

//        }
//        catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }
}

