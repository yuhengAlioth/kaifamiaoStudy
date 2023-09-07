package Code.JiHe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：CollectionsDemo
 * @代码功能：
 * @时间：2023/09/07/19:23
 */
public class CollectionsDemo {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add("免提问券");
        arrayList.add("智慧锦囊券");
        arrayList.add("手冲咖啡券");
        arrayList.add("早餐券");
        // 将指定的元素们添加到指定的集合中
        Collections.addAll(arrayList, "免晚自习券", "免考试罚抄券", "特殊照顾券");
//        arrayList.forEach(obj -> System.out.println(obj));
        LinkedList linkedList = new LinkedList();
        AoTeMan dj = new AoTeMan("迪迦", 80000, 56);
        AoTeMan sl = new AoTeMan("赛罗", 20000, 57);
        AoTeMan sw = new AoTeMan("赛文", 20000, 57);
        AoTeMan bly = new AoTeMan("贝利亚", 50000, 53);
//        linkedList.add(dj);
//        linkedList.add(sl);
//        linkedList.add(sw);
//        linkedList.add(bly);
//        linkedList.sort(null);
        // 二分查找 集合已经排序好，并且集合中的元素拥有自然排序的能力
//        System.out.println(Collections.binarySearch(linkedList, bly));
        ArrayList arrayList1 = new ArrayList<>();
        arrayList1.add("周末不放假");
        arrayList1.add("周末不放假");
        arrayList1.add("周末不放假");
        Collections.fill(arrayList1, "周末放假"); // 填充 arrayList1.size() 个
//        arrayList1.forEach(obj -> System.out.println(obj));
        ZHZ hf = new ZHZ("华妃", 40);
        ZHZ xdc = new ZHZ("夏冬春", 1);
        ZHZ alr = new ZHZ("安陵容", 45);
        linkedList.add(hf);
        linkedList.add(xdc);
        linkedList.add(alr);

//        System.out.println(Collections.max(linkedList, new ZHZComparator()));
        Collections.shuffle(linkedList); // 随机打乱集合 只能是List集合
        linkedList.forEach(obj -> System.out.println(obj));
        Collections.sort(linkedList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return ((ZHZ) o1).getDeadTime() - ((ZHZ) o2).getDeadTime() > 0 ? 1 : -1;
            }
        });

    }
}

