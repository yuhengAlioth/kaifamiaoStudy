package Code.PaiXu;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ShuZu
 * @文件名称：MaoPao
 * @时间：2023/08/12/17:20
 */
public class MaoPao {
    public static void main(String[] args) {
        // 冒牌排序
        // 从大到小排序
        int[] arr = new int[]{45,52,466,12,3,5};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
        System.out.print("从大到小排序：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print("===========================================");
        System.out.println();
        // 从小到大排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
        System.out.print("从小到大排序：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}

