package Code.LianBiao.ShuangXiang;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.LianBiao.ShuangXiang
 * @文件名称：DoubleLinked
 * @代码功能：双向链表
 * @时间：2023/09/04/18:57
 */
public class DoubleLinked {
    private Node first;
    private Node last;

    /**
     * 向链表里添加数据
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        // obj --> Node对象
        Node node = new Node(null, obj, null);
        if (first == null ) {
            first = node;
            last = first;
            return true;
        }
        // last 是目前链表的最后一个元素
        last.next = node;
        node.prev = last;
        last = node;
        return true;
    }

    /**
     * 删除链表第一个
     * @return
     */

    public boolean removeFirst() {
        if (first == null) {
            return false;
        }
        Node next = first.next;
        next.prev = null;
        first = next;
        return true;
    }

    /**
     * 删除链表最后一个
     * @return
     */
    public boolean removeLast() {
        if (last == null) {
            return false;
        }
        Node prev = last.prev;
        prev.next = null;
        last = prev;
        return true;
    }

    /**
     * 删除元素
     * @param obj
     * @return
     */
    public boolean remove(Object obj) {
        if (Objects.equals(first.value, obj)) {
            return removeFirst();
        }
        if (Objects.equals(last.value, obj)) {
            return removeLast();
        }
        // 从first.next开始往后找 value是obj的那个Node对象
        Node t = first.next;
        while (!Objects.equals(t.value, obj)) {
            t = t.next;
            if (t.next == null) {
                return false;
            }
        }
        // 此时t就是obj在的Node对象



        return false;

    }


    class Node {

        private Node prev;
        private Object value;
        private Node next;

        Node (Node prev, Object value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }



}

