import java.util.Scanner;
public class test{
	public static void main(String[] args){
		// 定义变量，储存信息
		String name = "喵星人";
		String gender = "男";
		int age = 24;
		double stature = 1.85;
			//利用Java输出自我介绍
		System.out.println("【基本信息】");
		System.out.print("姓名：" + name );
		System.out.println( "   性别：" + gender);
		System.out.print("年龄：" + age +"岁");
		System.out.println( "   身高：" + stature +"m");
		//实现输出等腰三角形
		System.out.println("    *");
		System.out.println("   ***");
		System.out.println("  *****");
		System.out.println(" *******");
		System.out.println("*********");
		// System.out.print是对输出结果不换行，而System.out.println的输出结果换行
		System.out.println("I’m lucky" + 123 + 456.58);
	}
}
