package Practise02;

import java.util.Scanner;

public class Lianxi0802_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入生日的月份");
        int month = input.nextInt();
        System.out.println("请输入生日的日期");
        int  day = input.nextInt();
        switch (month){
            case 1:
                if (day >= 1 && day <= 19){
                    System.out.println(month + "月" + day + "日" + "摩羯座");
                }else if (day >= 20 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "水瓶座");
                }
                break;
            case  2:
                if (day >= 1 && day <= 18){
                    System.out.println(month + "月" + day + "日" + "水瓶座");
                }else if (day >= 19 && day <= 29){
                    System.out.println(month + "月" + day + "日" + "双鱼座");
                }
                break;
            case 3:
                if (day >= 1 && day <= 20){
                    System.out.println(month + "月" + day + "日" + "双鱼座");
                }else if (day >= 21 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "白羊座");
                }
                break;
            case 4:
                if (day >= 1 && day <= 19){
                    System.out.println(month + "月" + day + "日" + "白羊座");
                }else if (day >= 20 && day <= 30){
                    System.out.println(month + "月" + day + "日" + "金牛座");
                }
                break;
            case 5:
                if (day >= 1 && day <= 20){
                    System.out.println(month + "月" + day + "日" + "金牛座");
                }else if (day >= 21 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "双子座");
                }
                break;
            case 6:
                if (day >= 1 && day <= 20){
                    System.out.println(month + "月" + day + "日" + "双子座");
                }else if (day >= 21 && day <= 30){
                    System.out.println(month + "月" + day + "日" + "巨蟹座");
                }
                break;
            case 7:
                if (day >= 1 && day <= 22){
                    System.out.println(month + "月" + day + "日" + "巨蟹座");
                }else if (day >= 23 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "狮子座");
                }
                break;
            case 8:
                if (day >= 1 && day <= 22){
                    System.out.println(month + "月" + day + "日" + "狮子座");
                }else if (day >= 23 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "处女座");
                }
                break;
            case 9:
                if (day >= 1 && day <= 22){
                    System.out.println(month + "月" + day + "日" + "处女座");
                }else if (day >= 23 && day <= 30){
                    System.out.println(month + "月" + day + "日" + "天秤座");
                }
                break;
            case 10:
                if (day >= 1 && day <= 22){
                    System.out.println(month + "月" + day + "日" + "天秤座");
                }else if (day >= 23 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "天蝎座");
                }
                break;
            case 11:
                if (day >= 1 && day <= 21){
                    System.out.println(month + "月" + day + "日" + "天蝎座");
                }else if (day >= 22 && day <= 30){
                    System.out.println(month + "月" + day + "日" + "射手座");
                }
                break;
            case 12:
                if (day >= 1 && day <= 21){
                    System.out.println(month + "月" + day + "日" + "射手座");
                }else if (day >= 22 && day <= 31){
                    System.out.println(month + "月" + day + "日" + "摩羯座");
                }
                break;
            default:
                System.out.println("请输入正确信息");
        }
    }
}
