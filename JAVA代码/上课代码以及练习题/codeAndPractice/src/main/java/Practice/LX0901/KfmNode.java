package Practice.LX0901;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0831.Linked
 * @文件名称：Node
 * @代码功能：单向链表节点
 * @时间：2023/09/01/16:36
 */
public class KfmNode {
    private Object value;
    private KfmNode next;
    public KfmNode(Object value, KfmNode next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public KfmNode getNext() {
        return next;
    }

    public void setNext(KfmNode next) {
        this.next = next;
    }
}

