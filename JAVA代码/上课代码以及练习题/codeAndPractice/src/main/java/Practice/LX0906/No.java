package Practice.LX0906;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：No
 * @代码功能：不重复元素集合
 * @时间：2023/09/06/20:01
 */
public class No {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(5);

        int count = 0;
        ArrayList uniqueElements = new ArrayList();

        System.out.println("原本元素分别为：");
        for (Object el : list) {
            Integer element = (Integer) el;
            System.out.print(element + "\t");
        }


        for (Object el : list) {
            Integer element = (Integer) el;
            if (!uniqueElements.contains(element)) {
                uniqueElements.add(element);
                count++;
            }
        }

        System.out.println();
        System.out.println("集合中共有 " + count + " 个不重复元素");

        System.out.println("不重复元素分别为：");
        for (Object el : uniqueElements) {
            Integer element = (Integer) el;
            System.out.print(element + "\t");
        }
    }
}

