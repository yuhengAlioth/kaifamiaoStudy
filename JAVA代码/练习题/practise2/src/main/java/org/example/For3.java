package org.example;

public class For3 {
    public static void main(String[] args) {
//        使用for循环输出所有7的倍数，直到200为止
        for (int i = 1;i <= 200; i++){
            if (i % 7 == 0){
                System.out.println(i);
            }
        }
    }
}
