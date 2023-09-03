package Practice.LX0831;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0831
 * @文件名称：Linked
 * @代码功能：链表
 * @时间：2023/09/01/17:23
 */
public class Linked {

    private Node first;
    private int size;

    /**
     * 获取链表的长度
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * 返回链表是否是空的
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 返回链表是否包含某个对象
     *
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return false;
    }

    /**
     * 添加元素到链表中
     *
     * @param o
     * @return
     */
    public boolean add(Object o) {
        // Object --> 放到Node对象里面去
        Node node = new Node(o, null);
        if (first == null) {
            first = node;
            return true;
        }
        Node t = first;
        System.out.println(t.next);
        while (t.next != null) {
            t = t.next;
        }
        t.next = node;
        return true;
    }

    /**
     * 删除某个元素
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        return false;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        return null;
    }

    /**
     * 返回指定元素的下标
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * 将链表转换成字符串 Linked[元素, 元素, ...]
     *
     * @return
     */
    @Override
    public String toString() {
        return "";
    }

    class Node {
        private Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next);
        }
    }
}

