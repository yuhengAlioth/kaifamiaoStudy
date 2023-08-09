package org.example;

public class ErFen {
    public static void main(String[] args) {
        // 二分查找（Binary Search）算法，也叫折半查找算法
        // 二分查找的是有序数列
        int[] arr = new int[]{3,4,42,65,72,86};
        int key = 99;
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (end >= start){
            if (arr[mid] == key){
                System.out.println(mid);
                break;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        if (start > end){
            System.out.println(-1);
        }

    }
}
