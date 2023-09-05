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
    private int size;

    /**
     * 向链表里添加数据
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        // obj --> Node对象  一定放到last的后面，那么prev一定指向的是last
        Node node = new Node(last, obj, null);
        if (first == null ) {
            first = node;
            last = first;
            size ++;
            return true;
        }
        // last 是目前链表的最后一个元素
        last.next = node;
        node.prev = last;
        last = node;
        size ++;
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
        // first.next == null 链表只有一个元素 让first置为null
        if (first.next == null) {
            first = null;
            last = null;
            size--;
            return true;
        }
        Node next = first.next;
        next.prev = null;
        first = next;
        size--;
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
        // 如果只有一个元素 last.prev == null
        if (last.prev == null) {
            last = null;
            first = null;
            size--;
            return true;
        }
        Node prev = last.prev;
        prev.next = null;
        last = prev;
        size--;
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
        t.prev.next = t.next;
        t.next.prev = t.prev;
        t.next = null;
        t.prev = null;
        size--;
        return true;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("DoubleLinked[ ");
        Node node = first;
        while (node.next != null) {
            sb.append(node.value + ", ");
            node = node.next;
        }
        // node.next == null
        sb.append(node.value + "]");
        return sb.toString();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int size() {
        return size;
    }


    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public Node getElement(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        // 通过index来判断从前往后还是从后往前
        int mid = size / 2;
        if (index < mid) {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            // size - index
            Node node = last;
            for (int i = 0; i < size - index; i++) {
                node = node.prev;
            }
            return node;
        }
    }

    public boolean set(int index, Object obj) {
        Node node = getElement(index);
        if (node == null) {
            return false;
        }
        node.value = obj;
        return true;
    }

    public boolean set(Object obj1, Object obj) {
        int i = indexOf(obj1);
        if (i < 0) {
            return false;
        }
        return set(i, obj);
    }

    public boolean add(int index, Object obj) {
        Node element = getElement(index);
        if (element == null) {
            return false;
        }
        Node node = new Node(null, obj, null);
        element.prev.next = node;
        node.prev = element.prev;
        node.next = element;
        element.prev = node;
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
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
    public int indexOf(Object obj) {
        if (first == null) {
            return -1;
        }
        Node node = first;
        int count = 0;
        while (!Objects.equals(node.value, obj)) {
            if (node.next == null) {
                return -1;
            }
            node = node.next;
            count++;
        }
        // node 是obj在的节点
        return count;
    }


}

