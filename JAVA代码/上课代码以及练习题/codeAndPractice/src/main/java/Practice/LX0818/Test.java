package Practice.LX0818;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0817
 * @文件名称：Test
 * @时间：2023/08/18/9:11
 */
public class Test {
    static Scanner intput = new Scanner(System.in);
    public static void main(String[] args) {
/*        JiSuan js = new JiSuan();
        System.out.print("请输入一个数字：");
        int n = intput.nextInt();
        js.suShuHe(n);
        int[] arr = new int[]{45,2,65,3,78,-5};
        js.chaRu(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(JiSuan.binarySearch(arr, 2));*/

        Vehicle vehicle = new Vehicle("特斯拉", 2023);
        vehicle.displayInfo();
        Vehicle car = new Car("宝马", 2023, 2);
        car.displayInfo();
        Motorcycle motorcycle = new Motorcycle("宝马", 2023, false);
        motorcycle.displayInfo();
    }
}

