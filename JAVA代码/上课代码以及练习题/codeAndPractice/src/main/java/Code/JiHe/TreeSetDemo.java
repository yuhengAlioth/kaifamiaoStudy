package Code.JiHe;

import java.util.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：TreeSetDemo
 * @代码功能：TreeSet集合
 * @时间：2023/09/07/15:32
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.equals(o2)){
                    return 0;
                }
                YongJieWuJian y1 = (YongJieWuJian) o1;
                YongJieWuJian y2 = (YongJieWuJian) o2;
                return y1.getAge() - y2.getAge() > 0 ? 1 : -1;
            }
        });
        //  如果比较器 还是自然排序 返回值是 0 就不放进去
        treeSet.add(new YongJieWuJian("岳山", 24, "无极帝国皇城", "前无极帝国武威候", "骑马、读兵书", "梁达伟"));
        treeSet.add(new YongJieWuJian("宁红叶", 25, "昆仑山腹", "昆仑玄女", "吹笛、色彩鲜艳的衣服", "黄莺"));

        NavigableSet navigableSet = treeSet.descendingSet(); // 返回一个新的降序集合
        Set a = treeSet.descendingSet();

        Iterator iterator = navigableSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();

        Iterator iterator1 = treeSet.iterator();// 升序

//        Iterator iterator2 = treeSet.descendingIterator();// 只降序输出

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }

}

