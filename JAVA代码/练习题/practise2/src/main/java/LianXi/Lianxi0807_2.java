package LianXi;

public class Lianxi0807_2 {
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
