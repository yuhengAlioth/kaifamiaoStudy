package org.example;

public class QianTao1 {
    public static void main(String[] args) {
//        输出乘法口诀
        int sum = 0;
        for (int i = 1;i < 10 ; i++){
            for (int j = 1;j <= i  ;j++){
                sum =  j * i;
                System.out.print(j + "x" + i + "=" + sum + "\t");
            }
            System.out.println();
        }
    }
}
