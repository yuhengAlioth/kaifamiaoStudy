package Practise06;

public class Lianxi0808_2 {
    public static void main(String[] args) {
        //  数组去重,给定一个整数数组，编写一个程序，移除数组中的重复元素，输出一个去重后的数组。
        int[] arr = new  int[]{62,52,30,62,4,12,52,62};
        int length = arr.length;
        // 循环数组
        for (int i = 0; i < length - 1; i++) {
            // 从第二个数开始循环循环
            for (int j = i + 1; j < length; j++) {
                // 判断这两个数是否相同
                if (arr [i] == arr[j]){
                    // 相同时将第二个元素移除
                    for (int k = j; k < length - 1 ; k++) {
                        // 后面的数将本次数替换掉
                        arr[k] = arr[ k + 1];
                    }
                    // 数组长度减少
                    length --;
                    // 下标也需要减少
                    j--;
                }
            }
        }

        for (int i = 0;i < length;i ++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
