public class Demo{
	public static void main(String[] args){
		// Ŀ�꣺���ջ����������������ʹ�á�
		int a = 10;
		int b = 2;
		System.out.println(a + b); // 12
		System.out.println(a - b); // 8
		System.out.println(a * b); // 20
		System.out.println(a / b); // 5 ���� / ���� = ����
		System.out.println(5 / 2); // 2
		System.out.println(5.0 / 2); // 2.5
		int i = 5;
		int j = 2;
		System.out.println(1.0 * i / j); // 2.5
		System.out.println(a % b); // 0
		System.out.println(3 % 2); // 1
		System.out.println("---------------------------------------");
		// Ŀ��2������ʹ��+���������ӷ��������
		int a2 = 5;
		System.out.println("abc" + a2); // abc5
		System.out.println(a2 + 5); // 10
		System.out.println("kaifamiao" + a2 + 'a'); // kaifamiao5a
		System.out.println(a2 + 'a' + "kaifamiao"); // 102kaifamiao
	}
}