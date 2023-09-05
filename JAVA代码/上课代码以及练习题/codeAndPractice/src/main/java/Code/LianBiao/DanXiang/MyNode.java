package Code.LianBiao.DanXiang;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.LianBiao.DanXiang
 * @文件名称：N
 * @代码功能：节点
 * @时间：2023/09/04/20:47
 */
public class MyNode {
    private Object value; // 存储的值

    private MyNode next; // 指向下一个值

    public MyNode(Object value, MyNode next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue(){
        return value;
    }
    public void setValue(Object value){
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}

