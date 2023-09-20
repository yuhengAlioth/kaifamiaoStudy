package Code.pool;

import java.util.concurrent.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.pool
 * @文件名称：Call
 * @代码功能：
 * @时间：2023/09/20/14:43
 */
public class Call {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<>(5)
        );
        Future<String> submit = threadPoolExecutor.submit(new MyCallable(4));
        Future<String> submit2 = threadPoolExecutor.submit(new MyCallable(100));
        try {
            System.out.println(submit.get());
            System.out.println(submit2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown(); //关闭线程
    }
}

class MyCallable implements Callable<String> {

    private int n;

    MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "计算1-" + n + "的和是：" + sum;
    }
}
