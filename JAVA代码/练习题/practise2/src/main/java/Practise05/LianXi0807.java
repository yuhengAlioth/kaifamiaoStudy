package Practise05;

public class LianXi0807 {
    public static void main(String[] args) {
        // 创建长度为10的int数组初始化值
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] n = new int[10];
        for (int i = 0;i < n.length;i ++){
            if (i == 0){
                n[i] = 1 * arr[i] * arr[i + 1];
            } else if (i == 9) {
                n[i] = arr[i - 1] * arr[i] * 1;
            }else {
                // 数组第n位元素 = 数组第n-1位元素 * 数组第n位元素 * 数组第n+1位元素
                n[i] = arr[i - 1] * arr[i] * arr[i + 1];
            }
        }
        for (int i = 0; i < n.length;i ++){
            System.out.println(n[i]);
        }
    }
}
