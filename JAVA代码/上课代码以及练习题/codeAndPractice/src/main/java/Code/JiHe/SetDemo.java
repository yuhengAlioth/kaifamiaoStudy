package Code.JiHe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：SetDemo
 * @代码功能：Set集合
 * @时间：2023/09/07/11:37
 */
public class SetDemo {

    public static void main(String[] args) {
        // 获取一个不可修改的Set集合
        Set set = Set.of("hym", "hyb", "lcw", "wt", "zyp", "tbc", "njc");


        // 迭代器
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // 因为无序列，没有索引，不支持随机访问，因此不能不能使用for循环遍历

        // 增强for循环
//        for (Object obj : set) {
//            System.out.println(obj);
//        }
        // forEach 方法输出
//        set.forEach(obj -> System.out.println(obj));


        HashSet hashSet = new HashSet(); // 16 负载因子 0.75
//        new HashSet<>(20); // 20 0.75
//        new HashSet<>(20, 0.8f);// 20 0.8
//        new HashSet<>(set);
        // remove()  equals

        // hashSet 要去重 就必须重写对象的 equals 和 hashCode() 且 hashCode() 里面的对象需要乘一个质数

//        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(new YongJieWuJian("岳山", 24, "无极帝国皇城", "前无极帝国武威候", "骑马、读兵书", "梁达伟")));
        System.out.println(hashSet.add(new YongJieWuJian("岳山", 24, "无极帝国皇城", "前无极帝国武威候", "骑马、读兵书", "梁达伟")));

        System.out.println(hashSet.add(1));
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.remove(1));

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object obj: hashSet) {
            System.out.println(obj);
        }

        hashSet.forEach(obj -> System.out.println(obj));

    }
}