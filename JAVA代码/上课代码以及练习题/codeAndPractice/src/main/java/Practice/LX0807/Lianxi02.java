package Practice.LX0807;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi02
 * @时间：2023/08/12/18:35
 */
public class Lianxi02 {
    public static void main(String[] args) {
        // 1.定义一个含有五个元素的数组,并为每个元素赋值,求数组中所有元素的最小值
        int[] arr = new int[]{51,2,748,45,15};
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ( min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}

