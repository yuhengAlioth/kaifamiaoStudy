package Practice.LX0906;

import java.util.LinkedList;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：LinkedListDemo
 * @代码功能：LinkedList集合
 * @时间：2023/09/06/17:09
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("我");
        linkedList.add("哎");
        linkedList.add("5");
        linkedList.add("我");
        System.out.println("原集合长度：" + linkedList.size());
        LinkedList list = (LinkedList) linkedList.clone();

        for (int i = 0; i < list.size(); i++) {
            if (list.getFirst().equals(list.getLast()) && list.size() == 1) {
                list.remove();
            } else if (list.getFirst().equals(list.getLast())) {
                list.removeFirst();
                list.removeLast();
            }
        }
        System.out.println("判断集合的剩余的长度：" + list.size());
        if (list.size() > 0) {
            System.out.println(linkedList + "\t不是回文集合");
        } else {
            System.out.println(linkedList + "\t是回文集合");
        }
    }

}

