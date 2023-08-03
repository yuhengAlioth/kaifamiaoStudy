package org.example;

public class For2 {
    public static void main(String[] args) {
//        输出所有水仙花数
        for (int i = 100;i <= 999; i ++){
//            分解数字
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;
            int res = a*a*a + b*b*b + c*c*c;
            if ( res == i){
                System.out.println("水仙花数有：" + res);
            }

        }
    }
}
