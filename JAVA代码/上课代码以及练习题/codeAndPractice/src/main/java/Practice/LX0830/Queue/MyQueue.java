package Practice.LX0830.Queue;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0830.Queue
 * @文件名称：MyQueue
 * @代码功能：队列实现
 * @时间：2023/08/30/21:30
 */
public class MyQueue extends Queue {
    Object[] arr;
    int count;
    int capacity = 10;

    public MyQueue(){
        arr = new Object[capacity];
    }
    public MyQueue(int capacity){
        if (capacity < 0) {
            capacity = 10;
        }
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    @Override
    void enqueue(Object element) {
        arr[count]=element;
        count++;
    }

    @Override
    Object dequeue() {
        if (count!=0){
            Object s = arr[0];
            System.arraycopy(arr,1,arr,0,count-1);
            return s;
        }
        return null;
    }

    @Override
    Object peek() {
        if (count!=0){
            return arr[0];
        }
        return null;
    }

    @Override
    boolean isEmpty() {
        if (count==0){
            return true;
        }
        return false;
    }

    @Override
    int size() {
        return count;
    }
}
class Test{
    public static void main(String[] args) {
        MyQueue my = new MyQueue();
        my.enqueue("1test");
        my.enqueue("2test");

        System.out.println(my.dequeue());
        System.out.println(my.peek());
        System.out.println(my.isEmpty());
        System.out.println(my.size());
    }


}

