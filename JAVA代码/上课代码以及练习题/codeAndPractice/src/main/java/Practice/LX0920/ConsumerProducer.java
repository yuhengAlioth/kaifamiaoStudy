package Practice.LX0920;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0920
 * @文件名称：ConsumerProducer
 * @代码功能：使用阻塞队列实现消费者生产者问题
 * @时间：2023/09/20/19:31
 */
public class ConsumerProducer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1); //创建一个容量为10的阻塞队列
//        new Thread(new Producer(queue)).start(); //启动生产者线程
        new Thread(new Consumer(queue)).start(); //启动消费者线程
        new Thread(() ->{
            try {
                for (int i = 1; i < 10; i++) {
                    System.out.println("生产: " + i);
                    queue.put(i);
                    Thread.sleep(1000); //模拟生产时间
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

}
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                System.out.println("生产: " + i);
                queue.put(i);
                Thread.sleep(1000); //模拟生产时间
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer i = queue.take(); //如果队列为空，会阻塞在这里
                System.out.println("消费: " + i);
                Thread.sleep(1500); //模拟消费时间
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
