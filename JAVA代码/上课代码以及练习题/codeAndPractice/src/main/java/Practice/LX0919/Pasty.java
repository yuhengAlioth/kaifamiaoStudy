package Practice.LX0919;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0919
 * @文件名称：Desk
 * @代码功能：
 * @时间：2023/09/19/19:24
 */
public class Pasty {
    private List<String> list = new ArrayList<>();


    public synchronized void cook() {
        if (list.isEmpty()) {
            String name = String.valueOf(System.currentTimeMillis());
            list.add(name);
            System.out.println(Thread.currentThread().getName() + "做了一个包子：" + name);
            try {
                Thread.sleep(500); // 模拟制作包子的过程  不会释放锁
                this.notify();
                this.wait();   // 无休止的等下去，等到有人唤醒   等 --> 释放锁 唤醒 --> 就绪状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.wait(200); // 等人唤醒，如果超过200这个时间，自己就醒了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 隐式 锁的是 this 对象
    public synchronized void eat() {
        if (!list.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + "吃了一个包子：" + list.remove(0));
            try {
                Thread.sleep(200);
                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class PastyTest {

    public static void main(String[] args) {
        Pasty pasty = new Pasty();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    pasty.cook();
                }
            }, "ʦ" + i).start();
        }
        for (int i = 0; i < 2; i ++) {
            new Thread(() -> {
                while (true) {
                    pasty.eat();
                }
            }, "厨子" + i).start();
        }
    }
}
