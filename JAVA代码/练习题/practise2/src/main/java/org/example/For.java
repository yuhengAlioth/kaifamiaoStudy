package org.example;

public class For {
    public static void main(String[] args) {
        double h = 8848860;

        int c = 0;
        for (double n = 0.1; n <= h; n *= 2){
            c ++;
        }
//        double i =0.1;
//        int n =0;
//        while(i<=8848860){
//            i *= 2;
//            n++;
//        }
        System.out.println("对折次数为：" + c);
    }
}
