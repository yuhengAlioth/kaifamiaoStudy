package Practice.LX0829.Stack;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829.Stack
 * @文件名称：Test
 * @代码功能：测试
 * @时间：2023/08/29/19:40
 */
public class Test {
    public static void main(String[] args) {


        MyStack myStack = new MyStack();

        myStack.push(6);
        System.out.println("栈顶元素：" + myStack.peek());
        System.out.println("出栈元素：" + myStack.pop());
        System.out.println(myStack.isEmpty() ? "空栈" : "非空栈");
        System.out.println("栈中元素个数：" + myStack.size());

    }
}

