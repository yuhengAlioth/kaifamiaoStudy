package Code.JiHe;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Consumer;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：YongJieWuJianTest
 * @代码功能：测试动态数组集合
 * @时间：2023/09/05/11:31
 */
public class YongJieWuJianTest {
    public static void main(String[] args) {
        Vector vector = new Vector(); // 可以传入参数设置数组长度

        vector.add(new YongJieWuJian("岳山", 24, "无极帝国皇城", "前无极帝国武威候", "骑马、读兵书", "梁达伟"));
        vector.add(new YongJieWuJian("宁红叶", 25, "昆仑山腹", "昆仑玄女", "吹笛、色彩鲜艳的衣服", "黄莺"));

        System.out.println("数组长度：" + vector.capacity());

        System.out.println("for循环输出");

        int size = vector.size();
        for (int i = 0; i < size; i++) {
            System.out.println(vector.get(i));
        }

        System.out.println("增强for循环输出");

        for (Object o : vector) {
            System.out.println(o);
        }

        System.out.println("Iterator迭代器输出");

        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) { // hasNext() 判断下一个是否为空
            System.out.println(iterator.next()); // next() 取出当前值，并且指向下一个
        }

        System.out.println("forEach(Consumer)方法输出");
        vector.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

        System.out.println("forEach()方法的lambda表达式输出");

        vector.forEach(obj -> System.out.println(obj));

        System.out.println("=========================");
        // 修改下标为 i 的其中一个属性值
        Object obj = vector.get(1);
        if (obj instanceof YongJieWuJian yjwj){
            yjwj.setHobby("未知");
        }
        System.out.println("=========================");
        // 方法一创建实现了Comparator接口的实现类对象
        vector.sort(new YJWJComparator());
        // 匿名类
        vector.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof YongJieWuJian q1 && o2 instanceof YongJieWuJian q2) {
                    return q1.getAge() - q2.getAge();
                }
                return 0;
            }
        });
        // 匿名类转换成lambda表达式
        vector.sort((o1, o2) -> {
            if (o1 instanceof YongJieWuJian q1 && o2 instanceof YongJieWuJian q2) {
                return q1.getAge() - q2.getAge();
            }
            return 0;
        });

        Iterator iterator2 = vector.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


    }

}
class YJWJComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof YongJieWuJian q1) {
            if (o2 instanceof YongJieWuJian q2) {
                return q1.getAge() - q2.getAge();
            }
        }
        return 0;
    }
}
