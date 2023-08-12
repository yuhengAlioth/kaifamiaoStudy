package Practice.LX0809;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0809
 * @文件名称：Lianxi01
 * @时间：2023/08/12/18:45
 */
public class Lianxi01 {
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
        System.out.println("=================================================");
        char[][] poetry = {
                {'十', '年', '生', '死', '两', '茫', '茫', '，', '不', '思', '量', '，', '自', '难', '忘', '。'},
                {'千', '里', '孤', '坟', '，', '无', '处', '话', '凄', '凉', '。'},
                {'纵', '使', '相', '逢', '应', '不', '识', '，', '尘', '满', '面', '，', '鬓', '如', '霜', '。'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡', '，', '小', '轩', '窗', '，', '正', '梳', '妆', '。'},
                {'相', '顾', '无', '言', '，', '惟', '有', '泪', '千', '行', '。'},
                {'料', '得', '年', '年', '肠', '断', '处', '，', '明', '月', '夜', '，', '短', '松', '冈', '。'}
        };
        // 取最长的数组长度
        int maxLength = poetry[0].length;
        // 假设第一个最长，从第二个开始查找最长的
        for (int i = 1; i < poetry.length; i++) {
            if (poetry[i].length > maxLength){
                maxLength = poetry[i].length;
            }
        }
        // 对数组进行反转90度
        for (int i = 0; i < maxLength; i++) {
            for (int j = poetry.length - 1;j >= 0 ; j--) {
                // 定义一维数组来存储二维数组里拿出来的值
                char[] arr = poetry[j];
                if (i > arr.length - 1){
                    // 判断下标是否越界
                    System.out.print("\t");
                }else {
                    System.out.print(arr[i] + "\t");
                }
            }
            System.out.println();
        }
    }
}

