package Code.LianBiao.DanXiang;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.LianBiao.DanXiangLianBiao
 * @文件名称：Test
 * @代码功能：测试单向链表
 * @时间：2023/09/04/17:31
 */
public class Test {
    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.add("njc");
        linked.add("tbc");
        linked.add("wt");
        linked.add("zyj");
        System.out.println(linked);
        System.out.println(linked.get(1));
        System.out.println(linked.indexOf("wt"));
//        linked.remove("tbc");
//        System.out.println(linked);
//        linked.delete("njc");
//        System.out.println(linked);
    }

}

