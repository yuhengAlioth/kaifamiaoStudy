import java.util.Scanner;
public class Demo4{
		public static void main(String[] args){
			// ������ȡ����Ķ���
			Scanner input = new Scanner(System.in);
			System.out.println("������һ���������");
			// ��ȡ������������
			int year = input.nextInt();
			// �ж�����Ƿ�������
			boolean a = year % 4 == 0;
			boolean b = year % 100 != 0;
			boolean c =year % 400 == 0;
			boolean res = a && b || c;
			System.out.println("���������" + year + "��" + "�Ƿ������ꣿ" + res);
			System.out.println(res ? "\t����" : "\tƽ��");
			
			
			Scanner input2 = new Scanner(System.in);
			System.out.println("������һ����");
			int num = input2.nextInt();
			// ����һ���ж��Ƿ�������
			boolean res2 = num % 2 != 0;
			System.out.print("ʹ��boolean�����жϽ��Ϊ��");
			System.out.println(res2 ? " \t����" : "\tż��");
			// ���������ж��Ƿ�������
			System.out.print("if...elseѭ���жϽ��Ϊ��");
			if(num % 2 == 0){
				System.out.println("\t" + num + " ��ż��");
			}else{
				System.out.println("\t" + num + " ������");
			}
			

		}
}