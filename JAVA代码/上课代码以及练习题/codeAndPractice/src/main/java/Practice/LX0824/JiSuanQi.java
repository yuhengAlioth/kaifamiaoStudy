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
        // 计算器
        //控制台输入一个计算公式(包含 + / - / * / / 4种运算符号)，计算出结果
        //要求:
        //1.满⾜运算规则，乘除的优先级⼤于加减
        //2.例如，输⼊：1+2*3-4/2 =5
        String str = "1+2*3-4/2";
        jiSuanQi(str);
    }

    public static void jiSuanQi(String str) {
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '*') {

                System.out.println(a);
                int num1 = 0;
                int num2 = 0;
                int one = 0;
                int two = 0;
                // 找*之前的符号到*之间的数字
                for (int j = 0; j < i; j++) {
                    if (str.charAt(j) == '+' || str.charAt(j) == '-') {
                        char b = str.charAt(j);
                        one = j + 1;
                        System.out.println(b);
                        String start = "";
                        for (int k = j + 1; k < i; k++) {
                            start += str.charAt(k);
                        }
                        num1 = Integer.parseInt(start);
                        System.out.println(num1);
                    }
                }


                // 找*之后的符号到*之间的数字
                for (int j = i; j < str.length() - 1; j++) {
                    if (str.charAt(j) == '+' || str.charAt(j) == '-' ) {
                        char c = str.charAt(j);
                        two = j;
                        System.out.println(c);
                        String end = "";
                        for (int k = i + 1; k < j; k++) {
                            end += str.charAt(k);
                        }
                        num2 = Integer.parseInt(end);
                        System.out.println(num2);
                    }
                }

                String sum = (num1 * num2) + "";
                System.out.println(sum);
                System.out.println(str.replace(str.substring(one, two), sum));

            }
        }
    }

}

