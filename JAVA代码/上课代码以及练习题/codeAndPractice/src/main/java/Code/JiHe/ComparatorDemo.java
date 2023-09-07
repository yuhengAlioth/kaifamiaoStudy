package Code.JiHe;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：ComparatorDemo
 * @代码功能：
 * @时间：2023/09/07/19:24
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        ZHZ hf = new ZHZ("华妃", 40);
        ZHZ xdc = new ZHZ("夏冬春", 1);
        ZHZ alr = new ZHZ("安陵容", 45);
        ZHZ[] zhzs = {hf, xdc, alr};
        // 让你排序的之后该如何排序，使用的传递的迭代器的compare方法
        // 当你需要给一些不具备自然排序的对象排序的时候，需要手动传入一个比较器，告诉Arrays如何去比较
//        Arrays.sort(zhzs, new ZHZComparator());
//        System.out.println(Arrays.toString(zhzs));
        // 当你需要给TreeSet添加一些不具备自然排序能力的对象的时候，手动传入一个比较器，告诉TreeSet如何去排序
//        TreeSet treeSet = new TreeSet<>(new ZHZComparator());
//        treeSet.add(hf);
//        treeSet.add(xdc);
//        treeSet.add(alr);
//        treeSet.forEach(obj -> System.out.println(obj));
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(hf);
        arrayList.add(xdc);
        arrayList.add(alr);
        // 此时排序就知道使用 new ZHZComparator() 比较器对象的 compare方法进行比较
        arrayList.sort(new ZHZComparator());
        arrayList.forEach(obj -> System.out.println(obj));
    }
}

class ZHZComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1.equals(o2)) { // 只让compare方法有一种返回值为0的情况
            return 0;
        }
        ZHZ z1 = (ZHZ) o1;
        ZHZ z2 = (ZHZ) o2;
        return z1.getDeadTime() - z2.getDeadTime() > 0 ? 1 : -1;
    }
}

