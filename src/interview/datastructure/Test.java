package interview.datastructure;

import java.util.Scanner;

/**
 * java的输入输出
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//输入两个数，输出其和
		/*int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(a + b);*/
		int i = in.nextInt(); //输入测试用例的组数
		while (i > 0) {	
			String s = in.next();
			System.out.print(s);
			i--;
		}
		
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 = Integer.valueOf(59);
		Integer i04 = new Integer(59);
		System.out.println(i01 == i02);
		System.out.println(i03 == i02);
		System.out.println(i04 == i02);
		
		System.out.println(i01 == i03);
		
		System.out.println(i01 == i04);
		System.out.println(i03 == i04);
	}
}
