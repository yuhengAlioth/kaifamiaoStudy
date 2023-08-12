package Practice.LX0808;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0808
 * @文件名称：Lianxi06
 * @时间：2023/08/12/18:44
 */
public class Lianxi06 {
    public static void main(String[] args) {
        // 数组的交集
        // 给定两个各不包含重复元素的数组 `arr` 和` arr1 `，求 `arr` 和` arr1 `的交集
        // (在 `arr `中有，`arr1` 中也包含的元素集合)，将交集中的元素放到一个数组中并输出。
        int[] arr = new int[]{48,25,43,13,2,5};
        int[] arr1 = new  int[]{5,20,12,48,25};
        int far = arr.length > arr1.length ? arr.length : arr1.length;
        // 新数组
        int[] newArr = new int[far];
        // 交集个数
        int count = 0;
        for (int i : arr) {
            for (int i1 : arr1) {
                if (i == i1){
                    newArr[count] = i;
                    count ++;
                    // System.out.print(i + "\t");
                }
            }
        }
        System.out.println("交集数有：" + count + " 个");

        other: for (int i : newArr) {
            if (i == 0 ){
                continue other;
            }
            System.out.print(i + "\t");
        }
    }
}

