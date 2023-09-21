package Practice.LX0920;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0920
 * @文件名称：SumArray
 * @代码功能：使用线程池来并行计算一个大数组的元素之和确保线程池中的线程能够正确协作。
 * @时间：2023/09/20/19:50
 */
public class SumArray {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 你的大数组

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 将数组拆分为任务并提交给线程池
        List<Future<Integer>> futures = new ArrayList<>();
        int chunkSize = array.length / 4;
        for (int i = 0; i < 4; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            Future<Integer> future = executorService.submit(() -> sumArray(array, start, end));
            futures.add(future);
        }

        // 收集并打印结果
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get(); // 这会阻塞，直到所有任务都完成
        }
        System.out.println("数组和为: " + totalSum);

        // 关闭线程池
        executorService.shutdown();
    }

    private static int sumArray(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}

