package Code.PaiXu;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ShuZu
 * @文件名称：XuanZe
 * @时间：2023/08/12/17:16
 */
public class XuanZe {
    public static void main(String[] args) {
        // 选择排序
        int[] arr = new int[]{12,56,3,47,785,11,58};

        // 从小到大排序
        // 开始循环数组
        for (int i = 0; i < arr.length; i++) {
            // 记录当前循环的值
            int temp = arr[i];
            // 记录当前循环的最小下标
            int minInedx = i;
            // 从当前循环的下一位开始找最小值
            for (int j = i + 1; j < arr.length; j++) {
                // 计算本次最小下标
                if (arr[minInedx] > arr[j]){
                    minInedx = j;
                }
            }
            // 将最小值交换到当前记录值的位置
            arr[i] = arr[minInedx];
            // 将当前的值放到刚刚找到最小值的位置上
            arr[minInedx] = temp;
        }
        System.out.print("从小到大排序：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print("===========================================");
        System.out.println();
        // 从大到小排序
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int maxInedx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[maxInedx] < arr[j]){
                    maxInedx = j;
                }
            }
            arr[i] = arr[maxInedx];
            arr[maxInedx] = temp;
        }
        System.out.print("从大到小排序：");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}

