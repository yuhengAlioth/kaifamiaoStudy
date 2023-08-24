package Code.ZiFuChuan;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ZiFuChuan
 * @文件名称：ZiFuChuanYanZheng
 * @时间：2023/08/23/11:39
 */
public class Email {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入邮箱：");
        String email = input.next();

        if (email.indexOf('@') == email.lastIndexOf('@')
                && !email.startsWith("@", 0)
                && !email.startsWith(".", email.length() - 1)
                && email.indexOf('@') > email.indexOf('.')
                && email.indexOf('@') >=0
                && email.indexOf('.') >= 0){
            System.out.println("合格的email");
        }else {
            System.out.println("不合格的email");
        }

    }
}

