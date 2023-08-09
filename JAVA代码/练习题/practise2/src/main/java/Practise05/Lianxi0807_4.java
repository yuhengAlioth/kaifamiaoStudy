package Practise05;

public class Lianxi0807_4 {
    public static void main(String[] args) {
        // 3．需求：求出数组中索引与索引对应的元素都是奇数的元素
        int[] arr =new int[]{45,21,3,25,36};
        //1、遍历数组
        for (int i = 0;i < arr.length;i ++) {
            //2、判断索引是否是奇数（索引 % 2 != 0）
            if (i % 2 != 0){
                //3、判断索引对应的元素是否是奇数(arr[索引] % 2 != 0)
                if (arr[i] % 2 != 0){
                    //4、满足条件输出结果
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
