package Practise07;

import java.util.Arrays;

public class Lianxi0809 {
    public static void main(String[] args) {
        // 翻转数组
        char[][] chunxiao = {
                {'春', '眠', '不', '觉', '晓'},
                {'处', '处', '闻', '啼', '鸟'},
                {'夜', '来', '风', '雨', '声'},
                {'花', '落', '知', '多', '少'}
        };
        for (int i = 0; i < chunxiao.length; i++) {
            System.out.println(Arrays.toString(chunxiao[i]));
        }
        for (int i = 0; i < chunxiao.length + 1; i++) {
            for (int j = chunxiao.length - 1; j >= 0; j--) {
                System.out.print(chunxiao[j][i] + "\t");
            }
            System.out.println();
        }
    }
}
