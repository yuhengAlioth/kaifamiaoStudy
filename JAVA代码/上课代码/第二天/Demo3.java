public class Demo3 {
public static void main(String[] args) {
		// 目标：掌握扩展赋值运算符的使用。
		// +=
		double a = 9.5;
		int b = 520;
		a += b; // a = (double)(a + b);
		System.out.println(a); // 529.5
		// -= 需求：发红包
		double i = 600;
		double j = 520;
		i -= j; // i = (double)(i - j);
		System.out.println(i); // 80
		int m = 10;
		int n = 5;
		// m *= n; // 等价形式： m = (int)(m * n)
		// m /= n; // 等价形式： m = (int)(m / n)
		m %= n; // 等价形式： m = (int)(m % n)
		System.out.println(m); // 0
	}
}