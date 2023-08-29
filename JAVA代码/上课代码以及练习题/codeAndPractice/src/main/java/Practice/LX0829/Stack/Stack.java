package Practice.LX0829.Stack;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829.Stack
 * @文件名称：Stack
 * @代码功能：栈的抽象类
 * @时间：2023/08/29/19:32
 */
public abstract class Stack {
    /**
     * 将元素压入栈顶
     * 入栈
     * @param element 要压入的元素
     */
    abstract void push(Object element);
    /**
     * 弹出栈顶元素并返回
     * 把栈顶元素删除，并返回
     * 出栈
     * @return 弹出的栈顶元素, 如果栈为空返回 null
     */
    abstract Object pop();
    /**
     * 返回栈顶元素，但不弹出
     * @return 栈顶元素
     */
    abstract Object peek();
    /**
     * 检查栈是否为空
     * @return 如果栈为空则返回true，否则返回false
     */
    abstract boolean isEmpty();
    /**
     * 返回栈中的元素个数
     * @return 栈中元素的个数
     */
    abstract int size();
}

