package Code.JiHe.treeMap;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe.treeMap
 * @文件名称：TreeMapTest
 * @代码功能：
 * @时间：2023/09/11/14:26
 */
public class TreeMapTest {
    public static void main(String[] args) {
        // 如果是无参构造，那么key要能排序，得拥有自然排序的能力 得实现Comparable接口
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "迪丽热巴");
        treeMap.put(4, "灰太狼");
        treeMap.put(3, "喜羊羊");
        treeMap.put(2, "黑猫警长");
        System.out.println(treeMap);


//        System.out.println(treeMap.firstEntry().getKey()); // 获取第一个键值对
//        System.out.println(treeMap.lastEntry().getValue()); // 最后一个键值对

//        System.out.println(treeMap.firstKey()); // 第一个键
//        System.out.println(treeMap.lastKey()); // 最后一个键

//        System.out.println(treeMap.floorEntry(1)); // 小于等于key的最大值
//        System.out.println(treeMap.lowerEntry(1)); // 小于key的最大值

//        System.out.println(treeMap.ceilingEntry(1)); // 大于等于key的最小值
//        System.out.println(treeMap.higherEntry(1)); // 大于key的最小值

//        System.out.println(treeMap.headMap(3)); // 小于key的所有集合
//        System.out.println(treeMap.headMap(3, true)); // 小于等于key的所有集合

//        System.out.println(treeMap.tailMap(3)); // 大于等于key的所有集合
//        System.out.println(treeMap.tailMap(3, false)); // 大于key的所有集合

//        System.out.println(treeMap.pollFirstEntry()); // 1
//        System.out.println(treeMap.pollLastEntry()); // 4

        System.out.println(treeMap.descendingMap()); // 会产生一个新的map集合，原来的不会变
        System.out.println(treeMap);

        System.out.println(treeMap.subMap(2, 4)); // 2, 3  [2, 4)
        System.out.println(treeMap.subMap(2, true, 4, true)); // 2, 3, 4 [2, 4]

        // 用其他类作为key时，需要拥有自然排序的能力 或者 在构建TreeMap的时候传递一个比较器
        // 有一个Emp类， id, 家庭住址  emp为键，家庭地址为value 存储到TreeMap中
        TreeMap<Emp, String> empTreeMap = new TreeMap<>(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.getId() - o2.getId();
            }
        });
        Emp e1 = new Emp(1, "aql", "腾讯");
        Emp e2 = new Emp(2, "ht", "米哈游");
        Emp e3 = new Emp(3, "gn", "网易");
        Emp e4 = new Emp(4, "ts", "暴雪");
        empTreeMap.put(e1, e1.getAddress());
        empTreeMap.put(e4, e4.getAddress());
        empTreeMap.put(e3, e3.getAddress());
        empTreeMap.put(e2, e2.getAddress());
        System.out.println(empTreeMap);
    }
}

