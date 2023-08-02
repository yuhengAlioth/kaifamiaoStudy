package org.example;

import java.util.Scanner;

public class Switch01 {
    public static void main(String[] args) {
//        先输入年份，在输入月份，返回这个月有多少天
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个年份");
        int year = input.nextInt();
        System.out.println("请输入一个月份");
        int month = input.nextInt();
// 第一版本
            switch (month){
                case 1,3,5,7,8,10,12:
                    System.out.println(year + "年" + month + "月" + "有31天");
                    break;
                case 4,6,9,11:
                    System.out.println(year + "年" + month + "月" + "有30天");
                    break;
                case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        System.out.println(year + "年" + month + "月" + "有29天");
                    }else {
                        System.out.println(year + "年" + month + "月" + "有28天");
                    }
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
// switch新特性---箭头表达式
        int days = 0;
        switch (month){
            case 1,3,5,7,8,10,12 -> days = 31;
            case 4,6,9,11 -> days = 30;
            case 2 -> {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
            }
            default -> days = 0 ;
        }
        if (days == 0){
            System.out.println("输入月份不正确");
        }else {
            System.out.println("switch新特性---箭头表达式：" + year + "年" + month + "月有" + days + "天");
        }
// switch新特性---yield
        int day = switch (month){
            case 1,3,5,7,8,10,12 -> 31;
            case 4,6,9,11 -> 30;
            case 2 -> {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default ->  0 ;
        };
        if (day == 0) {
            System.out.println("输入的月份不正确");
        } else {
            System.out.println("switch新特性---yield：" + year + "年" + month + "月有" + day + "天");
        }
    }
}
