package Code.LianBiao.DanXiang;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.LianBiao.DanXiangLianBiao
 * @文件名称：Node
 * @代码功能：单向链表节点
 * @时间：2023/09/04/17:22
 */
public class Node {
    private Object value;
    private Node next;
    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

