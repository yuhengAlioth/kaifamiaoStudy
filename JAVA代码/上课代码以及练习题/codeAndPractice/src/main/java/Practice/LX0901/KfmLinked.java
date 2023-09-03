package Practice.LX0901;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0831.Linked
 * @文件名称：Linked
 * @代码功能：链表
 * @时间：2023/09/01/16:32
 */
public class KfmLinked {

    private KfmNode first = null;
    private int size = 0; // 记录链表的长度

    /**
     * 给链表添加节点
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        // KfmLinked 存的是 KfmNode
        // Object 对象 放到 KfmNode
        KfmNode node = new KfmNode(obj, null);
        // 第一种链表（公司）为空
        if (first == null) {
            first = node;
            size++;
            return true;
        }
        // 第二种情况，链表不为空，寻找最后一个节点  公司不为空，找最后一个入职的人，让最后一个入职的人 领导这个新人
        // t 代表最后一个元素 假设first是最后一个元素
        KfmNode t = first;

        // 找最后一个元素 最后一个元素的条件是 t.next == null
        while (t.getNext() != null) {
            t = t.getNext();
        }
        // 此时 t 指代的就是链表的最后一个元素
        t.setNext(node);
        size++;
        return true;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 删除链表里的一个节点
     * @param obj
     * @return
     */
    public boolean remove(Object obj) {
        if (isEmpty()) {
            return false;
        }
        // 如果是第一个元素，直接让 first 为 null 并且只有一个元素
        if (Objects.equals(first.getValue(), obj) && first.getNext() == null) { // 要删除恰好是第一个元素 并且只有一个元素
            first = null;
            size--;
            return true;
        }
        // 如果删除第一个元素，让first指向下一个元素
        if (Objects.equals(first.getValue(), obj)) {
            first = first.getNext();
            size--;
            return true;
        }
        // 删除其他位置元素
        KfmNode t = first; // 前一个元素
        //  Objects.equals(t.getValue(), obj) == true  删除的依据
        while (!Objects.equals(t.getNext().getValue(), obj)) {
            t = t.getNext();
            if (t.getNext() == null) { // 说明是t最后一个元素了
                return false;
            }
        }
        // 找到了要删除的元素 t.getNext()
        KfmNode node = t.getNext(); // 要删除的元素
        t.setNext(node.getNext());
        size--;
        return true;
    }

    /**
     * 删除某个元素
     * @param obj
     * @return
     */
    public boolean delete(Object obj) {
        if (isEmpty()) {
            return false;
        }
        // obj 在的节点
        KfmNode t = first; // 假设first就是obj在的位置

        KfmNode prev = null; // 删除对象的前一个对象

        while (!Objects.equals(t.getValue(), obj)) {
            if (t.getNext() == null) {
                return false;
            }
            prev = t;
            t = t.getNext();
        }
        // 找到了obj在的节点t
        // 如果 t 是第一个元素
        if (prev == null) {
            KfmNode next = first.getNext(); //保存两个对象之间的连接
            first.setNext(null);
            first = next;
            size--;
            return true;
        }
        prev.setNext(t.getNext()); // 前一个指向删除对象的下一个对象
        t.setNext(null); // 删除对象指向变null
        size--;
        return true;
    }

    /**
     * 将链表转换成字符串 Linked[元素, 元素, ...]
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("KfmLinked[");

        KfmNode node = first;
        while (node.getNext() != null) {
            sb.append(node.getValue() + ", ");
            node = node.getNext();
        }
        sb.append(node.getValue() + "]");

        return sb.toString();
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        // 假设 first 就是查到的那个元素
        KfmNode node = first; // 最终查找的那个元素
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    /**
     * 返回指定元素的下标
     * @param obj
     * @return
     */
    public int indexOf(Object obj) {
        if (size == 0) {
            return -1;
        }
        KfmNode node = first; // 假设node就是我们要查找的obj在的节点
        int index = 0; // 对应的下标
        while (!Objects.equals(node.getValue(), obj)) {
            if (node.getNext() == null) { // 说明找到了最后一个还没找到
                return -1;
            }
            node = node.getNext();
            index++;
        }
        return index;
    }
}

