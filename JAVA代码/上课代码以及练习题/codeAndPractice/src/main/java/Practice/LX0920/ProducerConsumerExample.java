package Practice.LX0920;

import java.util.concurrent.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0920
 * @文件名称：ProducerConsumerExample
 * @代码功能：使用线程池实现一个简单的生产者-消费者模型其中有多个生产者和多个消费者。
 * @时间：2023/09/20/20:07
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        ExecutorService service = new ThreadPoolExecutor(5, 5,
                50, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5)
        );
        CookerRunnable c1 = new CookerRunnable(bq);
        CookerRunnable c2 = new CookerRunnable(bq);
        CookerRunnable c3 = new CookerRunnable(bq);
        EaterRunnable e1 = new EaterRunnable(bq);
        EaterRunnable e2 = new EaterRunnable(bq);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3);
        service.execute(e1);
        service.execute(e2);
    }
}
class CookerRunnable implements Runnable {

    private BlockingQueue<String> bq;

    public CookerRunnable(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    public void run() {
        while (true) {
            synchronized (CookerRunnable.class) {
                String name = String.valueOf(System.currentTimeMillis());
                try {
                    bq.put(name);
                    System.out.println(Thread.currentThread().getName() + "生产：" + name);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
class EaterRunnable implements Runnable {

    private BlockingQueue<String> bq;

    public EaterRunnable( BlockingQueue<String> bq) {
        this.bq = bq;
    }

    public void run() {
        while (true) {
            synchronized (EaterRunnable.class) {
                try {
                    String take = bq.take();
                    System.out.println(Thread.currentThread().getName() + "消费：" + take);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}