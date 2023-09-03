package Practice.LX0830.Queue;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0830.Queue
 * @文件名称：Test
 * @代码功能：测试队列
 * @时间：2023/09/01/16:30
 */
public class Test {
    public static void main(String[] args) {
        MyQueue my = new MyQueue();
        my.enqueue("1test");
        my.enqueue("2test");

        System.out.println(my.dequeue());
        System.out.println(my.peek());
        System.out.println(my.isEmpty());
        System.out.println(my.size());
    }
}

