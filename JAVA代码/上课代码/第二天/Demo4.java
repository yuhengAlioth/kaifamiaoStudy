import java.util.Scanner;
public class Demo4{
		public static void main(String[] args){
			// 创建获取输入的对象
			Scanner input = new Scanner(System.in);
			System.out.println("请输入一个计算年份");
			// 获取输入的年份数字
			int year = input.nextInt();
			// 判断年份是否是闰年
			boolean a = year % 4 == 0;
			boolean b = year % 100 != 0;
			boolean c =year % 400 == 0;
			boolean res = a && b || c;
			System.out.println("你输入的是" + year + "年" + "是否是闰年？" + res);
			System.out.println(res ? "\t闰年" : "\t平年");
			
			
			Scanner input2 = new Scanner(System.in);
			System.out.println("请输入一个数");
			int num = input2.nextInt();
			// 方法一：判断是否是奇数
			boolean res2 = num % 2 != 0;
			System.out.print("使用boolean类型判断结果为：");
			System.out.println(res2 ? " \t奇数" : "\t偶数");
			// 方法二：判断是否是奇数
			System.out.print("if...else循环判断结果为：");
			if(num % 2 == 0){
				System.out.println("\t" + num + " 是偶数");
			}else{
				System.out.println("\t" + num + " 是奇数");
			}
			

		}
}