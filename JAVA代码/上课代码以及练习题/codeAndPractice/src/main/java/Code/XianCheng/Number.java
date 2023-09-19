package Code.XianCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.XianCheng
 * @文件名称：Number
 * @代码功能：
 * @时间：2023/09/19/11:43
 */
public class Number {
    private int num = 0;

    public void add() {
//        synchronized (this){
        for (int i = 0; i < 100; i++) {
            num++;
        }
//        }
    }

    public void sub() {
//        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                num--;
            }
//        }
    }

    public int getNum() {
        return num;
    }

}

class NumberTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread add = new Thread(() -> {
            synchronized (number) {
                number.add();
            }
        });

        Thread sub = new Thread(() -> {
            synchronized (number) {
                number.sub();
            }
        });

        add.start();
        sub.start();

        try {
            add.join();
            sub.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(number.getNum());
    }
}

