package Practice.LX0807;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi04
 * @时间：2023/08/12/18:36
 */
public class Lianxi04 {
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

