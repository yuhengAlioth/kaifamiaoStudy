package Code.JiHe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：CompareDemo
 * @代码功能：
 * @时间：2023/09/07/19:25
 */
public class CompareDemo {
    public static void main(String[] args) {
        // 自然排序 元素（引用数据类型）自身拥有的相互比较的能力
        // 让类声明的时候实现 Comparable 接口 重写 compareTo 方法 告诉元素自然排序的属性应该是哪一个
        // 对象本身去调用 传递另外一个对象
        // 比较器 Comparator 不想去修改类的结构，但是还是想让他们比较，传递一个 匿名类对象 重写 compare(o1, o2)
        // 告诉他们比较的方法，具体是哪个属性去比较
        AoTeMan dj = new AoTeMan("迪迦", 80000, 56);
        AoTeMan sl = new AoTeMan("赛罗", 20000, 57);
        AoTeMan sw = new AoTeMan("赛文", 20000, 57);
        String s1 = "abc";
        String s2 = "bcd";
        // > <  所有引用数据类型都不能用 > < 等直接比较
        System.out.println(s1.compareTo(s2) > 0);
        System.out.println(dj.compareTo(sl) > 0);
        AoTeMan[] aoTeMEN = {dj, sl, sw};
        Arrays.sort(aoTeMEN);
        System.out.println(Arrays.toString(aoTeMEN));
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(dj);
        arrayList.add(sl);
        arrayList.add(sw);
        // sort如果传递的比较器对象为空，会按照自然排序规则进行排序
        arrayList.sort(null);
        TreeSet treeSet = new TreeSet<>();
        // 只要自然排序（比较器）返回的值是 0 就不放进去，因此特殊处理了一个自然排序里面的返回值
        treeSet.add(dj);
        treeSet.add(sl);
        treeSet.add(sw);
    }
}

