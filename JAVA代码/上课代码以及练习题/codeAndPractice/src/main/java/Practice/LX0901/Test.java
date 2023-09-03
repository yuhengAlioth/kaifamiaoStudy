package Practice.LX0901;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0831.Linked
 * @文件名称：Test
 * @代码功能：测试链表
 * @时间：2023/09/01/16:33
 */
public class Test {
    public static void main(String[] args) {
        KfmLinked kfmLinked = new KfmLinked();
        kfmLinked.add("njc");
        kfmLinked.add("tbc");
        kfmLinked.add("wt");
        kfmLinked.add("zyj");
        System.out.println(kfmLinked);
        System.out.println(kfmLinked.get(1));
        System.out.println(kfmLinked.indexOf("wt"));
//        kfmLinked.remove("tbc");
//        System.out.println(kfmLinked);
//        kfmLinked.delete("njc");
//        System.out.println(kfmLinked);
    }
}

