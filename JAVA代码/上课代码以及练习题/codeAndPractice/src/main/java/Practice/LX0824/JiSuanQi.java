package Practice.LX0824;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：JiSuanQi
 * @时间：2023/08/24/21:12
 */
public class JiSuanQi {
    public static void main(String[] args) {
        // 计算器  1+2-2*3-2/1
        String str = "2+2-2*3-2/1-20";
        calculator(str);
        System.out.println(calculator(str));

    }

    public static int calculator(String str) {
        // 1. 找乘除
        // 当前位的前一位往前找不是数字的就停止，然后裁剪
        // 当前位后一位往后找不是数字的停止，然后裁剪
        // 2. 然后找加减
        str = str.replace(" ", ""); // 将输入的字符串的空格替换为空字符串
        // 乘除
        while (str.contains("*") || str.contains("/")) { // 匹配式子中的乘除法
            int index = str.indexOf("*"); // 乘法下标
            int index2 = str.indexOf("/"); // 除法下标
            if (index == -1) { // 没有乘法
                index = index2;
            } else if (index2 != -1 && index2 < index) { // 除法，并且除法在左边
                index = index2;
            }
            int left = index - 1; // 左边符号下标
            int right = index + 1; // 右边符号下标
            // 找左边运算符在的下标
            while (left >= 0 && Character.isDigit(str.charAt(left))) {
                left--;
            }
            // 找右边运算符在的下标
            while (right < str.length() && Character.isDigit(str.charAt(right))) {
                right++;
            }

            int leftNumber = Integer.parseInt(str.substring(left + 1, index)); // 获取左边的数字
            int rightNumber = Integer.parseInt(str.substring(index + 1, right)); // 获取右边的数字

            int temp = 0;
            // 当前这个运算符的计算结果
            if (str.charAt(index) == '*') {
                temp = leftNumber * rightNumber;
            } else {
                temp = leftNumber / rightNumber;
            }
            // 本次计算的结果替换掉本次计算的式子
            str = str.substring(0, left + 1) + temp + str.substring(right);
        }
        // 加减
        while (str.indexOf('+') != -1 || str.indexOf('-') != -1) {
            int index = str.indexOf('+');
            int index2 = str.indexOf('-', 1); // 避免找到 - 号
            if (index == -1) {
                index = index2;
            } else if (index2 != -1 && index2 < index) {
                index = index2;
            }
            if (index == -1) {
                break;
            }
            int left = index - 1;
            int right = index + 1;
            // 找左边的上一个运算符
            while (left >= 0 && (Character.isDigit(str.charAt(left)) || str.charAt(left) == '-')) {
                left--;
            }
            // 找右边的下一个运算符
            while (right < str.length() && Character.isDigit(str.charAt(right))) {
                right++;
            }

            int leftNumber = Integer.parseInt(str.substring(left + 1, index));
            int rightNumber = Integer.parseInt(str.substring(index + 1, right));
            int temp = 0;

            if (str.charAt(index) == '+') {
                temp = leftNumber + rightNumber;
            } else {
                temp = leftNumber - rightNumber;
            }
            str = str.substring(0, left + 1) + temp + str.substring(right);
        }
        return Integer.parseInt(str);
    }

}

