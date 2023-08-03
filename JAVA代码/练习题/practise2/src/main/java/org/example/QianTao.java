package org.example;

public class QianTao {
    public static void main(String[] args) {
//        输出等腰三角形
        for (int i = 1;i < 6 ; i++){
            for (int k = 5;k > i; k--){
                System.out.print(" ");
            }
            for (int j = 0;j < 2 * i -1  ;j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
