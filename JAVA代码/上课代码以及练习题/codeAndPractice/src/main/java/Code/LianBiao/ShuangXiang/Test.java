package Code.LianBiao.ShuangXiang;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.LianBiao.ShuangXiang
 * @文件名称：Test
 * @代码功能：双向链表测试
 * @时间：2023/09/04/18:59
 */
public class Test {
    public static void main(String[] args) {

        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.add("zyj");
        doubleLinked.add("lgw");
        doubleLinked.add("wcheng");
        doubleLinked.add("wt");
        doubleLinked.removeFirst();
        doubleLinked.removeLast();
    }
}

