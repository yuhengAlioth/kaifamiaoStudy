package Practise07;

import java.util.Arrays;

public class Lianxi0809_2 {
    public static void main(String[] args) {
        // 数字排序
        // 设 names 数组中存放学生姓名
        String[] names = { "安琪拉" , "王昭君" , "蔡文姬" , "妲己" , "张良" };
        // 设 courses 数组中依次存放三门课程的名称
        String[] courses = { "C++" , "Java" , "Python" };
        // 设 scores 数组中依次存储的是 names 数组中各个学生的 C++ 、Java 、Python 课程的成绩
        int[][] scores = {
                { 90 , 89 , 75 } ,
                { 59 , 40 , 100 } ,
                { 100 , 99 , 80 } ,
                { 80 , 61 , 61 } ,
                { 60 , 100 , 99 } ,
        };
        // 设计程序按照各个学生的 Java 成绩进行排序 ( 降序 )
        for (int i = 0; i < scores.length; i++) {
            for (int j = i; j < scores.length; j++) {
                if (scores[i][1] < scores[j][1]){
                    // 输出所有科目
                    for (int k = 0; k < 3; k++) {
                        scores[i][k] = scores[i][k] ^ scores[j][k];
                        scores[j][k] = scores[i][k] ^ scores[j][k];
                        scores[i][k] = scores[i][k] ^ scores[j][k];
                    }
                }
            }
        }
        for (int i = 0; i < scores.length; i++) {
            System.out.println(Arrays.toString(scores[i]));
        }
        System.out.println("======================================");
        // 设计程序，根据学生总成绩进行排序(降序排列)，并输出学生姓名、每门课程的名称和该学生的成绩、该学生的总成绩
        int[] sums = new int[scores.length];
        for (int i = 0; i < sums.length; i++) {
            for (int i1 : scores[i]) {
                sums[i] += i1;
            }
        }
        // 先把sums冒泡排序
        for (int i = 0; i < sums.length - 1; i++) {
            for (int j = 0; j < sums.length - 1 - i; j++) {
                if (sums[j] < sums[j + 1]) {
                    // 交换总成绩数组
                    sums[j] = sums[j + 1] ^ sums[j];
                    sums[j + 1] = sums[j + 1] ^ sums[j];
                    sums[j] = sums[j + 1] ^ sums[j];
                    // 交换单科成绩的数组
                    int[] temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    // 交换姓名的数组
                    String name = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = name;
                }
            }
        }
        System.out.print("姓名\t\t\t课程名称以及各科成绩\t\t总分");
        System.out.println();
        for( int i = 0 ; i < scores.length ; i++ ){
            System.out.print( names[ i ] + "\t" ); // 输出学生姓名
            for( int j = 0 ; j < scores[ i ] .length ; j++ ){
                System.out.print( courses[ j ] + ":");// 输出课程名称
                System.out.print( scores[ i ][ j ] ); // 输出课程成绩
                if( j < scores[ i ] .length - 1 ) {
                    System.out.print( " , " );
                }else {
                    System.out.print("\t");
                }
            }
            System.out.print(sums[i]);
            System.out.println();
        }

    }
}
