package Practice.LX0907;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0907
 * @文件名称：No
 * @代码功能：不重复
 * @时间：2023/09/08/9:15
 */
public class No {
    public static void main(String[] args) {
        List numberList = new ArrayList();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(4);
        numberList.add(3);

        Set uniqueElements = new HashSet();
        List duplicateElements = new ArrayList();

        for (Object number : numberList) {
            if (uniqueElements.contains(number)) {
                duplicateElements.add(number);
            } else {
                uniqueElements.add(number);
            }
        }

        uniqueElements.removeAll(duplicateElements);

        System.out.println("集合中共有 " + uniqueElements.size() + " 个不重复元素");
        System.out.println("不重复元素：" + uniqueElements);
    }
}

