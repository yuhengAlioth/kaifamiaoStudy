package Code.LianBiao.DanXiang;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.LianBiao.DanXiang
 * @文件名称：L
 * @代码功能：单向链表
 * @时间：2023/09/04/20:46
 */
public class MyLinked {
    private MyNode first = null; // 链表第一个值
    private int size = 0; // 链表的长度

    /**
     * 向链表里面添加元素
     *
     * @param obj 传入一个对象
     * @return 返回布尔值，true表示添加成功，false表示添加失败
     */
    public boolean add(Object obj) {
        // 将对象放入到节点里
        MyNode node = new MyNode(obj, null);
        // 当链表是空链表时
        if (first == null) {
            first = node;
            size++;
            return true;
        }
        // 当链表非空时，找最后一个元素
        MyNode temp = first;
        // 找到最后一个元素，当 temp.next == null 时这个元素就是最后一个
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        // 将传入的元素放入链表
        temp.setNext(node);
        size++;
        return true;

    }

    /**
     * 判断链表是否为空
     *
     * @return 返回布尔值表示是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 删除链表里的元素
     *
     * @param obj 传入的元素
     * @return 返回布尔值表示是否删除成功
     */
    public boolean remove(Object obj) {
        // 如果链表是空的
        if (isEmpty()) {
            return false;
        }
        // 如果删除的是第一个元素并且链表里面只有一个元素
        if (Objects.equals(first.getValue(), obj) && first.getNext() == null) {
            first = null;
            size--;
            return true;
        }
        // 如果删除的是第一个元素
        if (Objects.equals(first.getValue(), obj)) {
            first = first.getNext(); // 将要删除的元素的下一个元素变为第一个元素
            size --;
            return true;
        }
        // 删除其他卫视的元素
        MyNode temp = first; // 前一个元素
        while (!Objects.equals(temp.getNext().getValue(),obj)){
            temp = temp.getNext();
            // 找到最后一个元素都没有找到
            if (temp.getNext() == null){
                return false;
            }
        }
        // 找到了要删除的元素 temp.getNext()
        MyNode node = temp.getNext(); // 要删除的元素
        temp.setNext(node.getNext());
        size--;
        return true;

    }
}

