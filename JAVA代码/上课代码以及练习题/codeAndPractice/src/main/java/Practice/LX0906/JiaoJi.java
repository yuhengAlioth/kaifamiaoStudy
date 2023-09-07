package Practice.LX0906;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：JiaoJi
 * @代码功能：两个集合的交集
 * @时间：2023/09/07/9:02
 */
public class JiaoJi {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        ArrayList list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);


        list1.retainAll(list2);
        list1.forEach(obj -> System.out.println(obj));

    }

}

