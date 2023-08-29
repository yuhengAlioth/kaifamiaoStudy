package Practice.LX0829.Stack;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829.Stack
 * @文件名称：MyStack
 * @代码功能：实现栈的抽象类
 * @时间：2023/08/29/19:34
 */
public class MyStack extends Stack {
    Object[] arr; // 定义一个数组
    int count; // 数组元素的下标
    int capacity = 10; // 数组初始长度

    public MyStack() {
        arr = new Object[capacity];
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
            capacity = 10;
        }
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    @Override
    void push(Object element) { // 入栈
        arr[count] = element;
        count++;
    }

    @Override
    Object pop() { // 出栈
        // 删除数组 count-1 位置的元素 1,2,3,0,0,0,0,0,0
        Object remove = arr[count - 1];
        System.arraycopy(arr, 0, arr, 0, count - 1);
        System.arraycopy(arr, count, arr, count - 1, arr.length - count);
        count--;
        return remove;
    }

    @Override
    Object peek() {
        Object nowNum = arr[count-1];
        return nowNum;
    }

    @Override
    boolean isEmpty() {
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
            if (arr[i] != null){
                return false;
            }
        }

        return true;
    }

    @Override
    int size() {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null){
                num ++;
            }
        }
        return num;
    }
}

