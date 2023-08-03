package org.example;

public class For6 {
    public static void main(String[] args) {
//        计算并且输出从10到1之间所有奇数的乘积
        int pro = 1;
        for (int i = 10; i >= 1; i --){
            if (i % 2 != 0){
                pro *= i;
            }
        }
        System.out.println(pro);
    }
}
