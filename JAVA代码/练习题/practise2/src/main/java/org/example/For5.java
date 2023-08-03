package org.example;

public class For5 {
    public static void main(String[] args) {
//        计算并且输出从1到100之间所有偶数的和
        int sum = 0;
        for (int i = 1;i <= 100; i ++){
            if (i % 2 == 0){
                sum +=  i;
            }
        }
        System.out.println(sum);
    }
}
