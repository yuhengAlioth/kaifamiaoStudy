package Practice.LX0818;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0817
 * @文件名称：JiSuan
 * @时间：2023/08/18/9:03
 */
public class JiSuan {
    public int n;
    public JiSuan(){

    }
    public JiSuan(int n){
        this.n = n;
    }
    public void suShuHe(int n){
        int sum = 0;
        System.out.print(n + "以内的素数有：");
        other : for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0){
                    count ++;
                }
                if (count > 2){
                    continue other;
                }
            }
            if (count == 2){
                System.out.print(" " + i + " ");
                sum += i;
            }
        }
        System.out.println();
        System.out.println(n + "以内的素数和为：" + sum);
    }

    public  void chaRu(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1];
            int index = i;
            while ( index >= 0 && temp < arr[index]){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = temp;
        }
    }
    /**
     * 二分查找指定值在数组中的下标
     * @param arr 要查找的数组
     * @param key 要查询的数字
     * @return 该数字所在的下标，如果存在返回下标，不存在返回 -1
     */
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

