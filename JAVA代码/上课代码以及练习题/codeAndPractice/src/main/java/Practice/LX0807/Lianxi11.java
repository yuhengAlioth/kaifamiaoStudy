package Practice.LX0807;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi11
 * @时间：2023/08/12/18:40
 */
public class Lianxi11 {
    public static void main(String[] args) {
        // 10. 现有一个int 数组，数组中有十个元素。将数组反转后输出
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("原数组");
        for (int a: arr) {
            System.out.print(a + " ");
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int a = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = a;
        }
        System.out.println(" ");
        System.out.println("反转后数组");
        for (int b: arr) {
            System.out.print(b + " ");
        }
    }
}

