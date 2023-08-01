public class Demo2{
	public static void main(String[] args){
		// 目标：掌握自增自减运算符的使用。
		int a = 10;
		++a;
		System.out.println(a); // 11

		--a;
		System.out.println(a); // 10

		System.out.println("--------------------------------------");

		int i = 10;
		int rs = ++i;
		System.out.println(rs); // 11
		System.out.println(i); // 11

		int j = 10;
		int rs2 = j++;
		System.out.println(rs2); // 10
		System.out.println(j); // 11


		int num1 = 2;
		int num2 = 3;
		int num3 = ++num1; // num3 = 3 num1 = 3
		System.out.println(++num1 + num2++ + num3); // 10 num1 = 4 num2 = 4 num3 = 3
		System.out.println(--num1 + num2-- + --num3);// 9 num1 = 3 num2 = 3 num3 = 2
		System.out.println(num1-- + num2-- + --num3);// 7 num1 = 2 num2 = 2 num3 = 1
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
}