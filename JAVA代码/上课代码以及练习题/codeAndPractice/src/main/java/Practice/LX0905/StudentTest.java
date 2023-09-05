package Practice.LX0905;

import java.util.Vector;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0905
 * @文件名称：Test
 * @代码功能：测试集合
 * @时间：2023/09/05/20:07
 */
public class StudentTest {
    static Vector vector = new Vector();

    public static void main(String[] args) {

        String name = "天海";
        String name2 = "岳山";
        String name3 = "无尘";
        add(name);
        add(name2);
        add(name3);

        String message = remove("dsd") ? "删除成功！" : "没有这个人,无法删除！！！";
        System.out.println(message);

        System.out.println("集合里所有学生名称：");
        for (Object o : vector) {
            System.out.println(o);
        }

    }

    public static void add(String name) {
        vector.add(new Student(name));
    }

    public static boolean remove(String name) {
        return vector.remove(new Student(name));
    }

}

