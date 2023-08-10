package Practise08;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise08
 * @文件名称：Lianxi0810_6
 * @时间：2023/08/10/19:35
 */
public class Lianxi0810_6 {
    public static void main(String[] args) {
        boolean num = isBothConditionsTrue(true,true);
        System.out.println(num);
    }
    //  编写一个方法 isBothConditionsTrue(boolean condition1,boolean condition2)，
    //  该方法接收两个布尔类型的参数 condition1 和 condition2，判断这两个条件是否都为 true。
    //  如果两个条件都为 true，则返回 true，否则返回false。
    public  static boolean isBothConditionsTrue(boolean condition1,boolean condition2){
        boolean status = false;
        if (condition1 == true && condition2 == true){
            status = true;
        }
        return  status;
    }
}

