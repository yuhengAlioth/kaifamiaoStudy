package Practice.LX0919;

import Practice.LX0908.Exec01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0919
 * @文件名称：JiaoTi
 * @代码功能：字母数字交替出现
 * @时间：2023/09/19/20:01
 */
public class AlternatePrinting {
    public static void main(String[] args) {
        // 创建两个线程，一个线程负责打印数字，另一个线程负责打印字母。确保它们交替执行，并使用线程通信
        // 来协调它们。
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) ('a' + i));
                    obj.notify();
                    try {
                        if (i < 25) {
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 26; i++) {
                    System.out.print(i + 1 + " ");
                    obj.notify();
                    try {
                        if (i < 25) {
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}



