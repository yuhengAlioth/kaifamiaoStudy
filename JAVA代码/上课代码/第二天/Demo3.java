public class Demo3 {
public static void main(String[] args) {
		// Ŀ�꣺������չ��ֵ�������ʹ�á�
		// +=
		double a = 9.5;
		int b = 520;
		a += b; // a = (double)(a + b);
		System.out.println(a); // 529.5
		// -= ���󣺷����
		double i = 600;
		double j = 520;
		i -= j; // i = (double)(i - j);
		System.out.println(i); // 80
		int m = 10;
		int n = 5;
		// m *= n; // �ȼ���ʽ�� m = (int)(m * n)
		// m /= n; // �ȼ���ʽ�� m = (int)(m / n)
		m %= n; // �ȼ���ʽ�� m = (int)(m % n)
		System.out.println(m); // 0
	}
}