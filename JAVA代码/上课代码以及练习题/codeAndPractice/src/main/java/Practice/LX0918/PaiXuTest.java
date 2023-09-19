package Practice.LX0918;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0918
 * @文件名称：PaiXu
 * @代码功能：多线程排序
 * @时间：2023/09/18/19:28
 */
public class PaiXuTest {

    // 编写一个多线程排序程序，将一个大型数组（或者集合）分成若三部分，
    // 创建三个线程每个线程对其中一部分进行排序，然后主线程(main)等待所有线程完成，最后输出这个数组。
    public static void main(String[] args) {
        int[] array = new int[]{456,455,11,75,156,744,221,77,66,9,4,88};

        // 创建并启动三个线程分别对每部分进行排序
        Thread thread1 = new SortingThread(array,0,3);
        Thread thread2 = new SortingThread(array,4,7);
        Thread thread3 = new SortingThread(array,8,11);

        thread1.start();
        thread2.start();
        thread3.start();

        // 等待所有线程完成排序
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 输出排序后的数组
        System.out.println(Arrays.toString(array));
    }
}

class SortingThread extends Thread {
    private int[] arr;
    private int start;
    private int end;

    public SortingThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run() {
//        Arrays.sort(arr, start, end);
        sort();
        System.out.println("当前数组：" + Arrays.toString(arr));
    }


    private void sort() {
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
