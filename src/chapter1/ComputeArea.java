package chapter1;

import java.util.Scanner;


public class ComputeArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		/*final double PI = 3.14;
		double radius = in.nextDouble();
		double area = radius * radius * PI;
		System.out.println("the area for the circle of " + radius + " is: " + area);
		
		int x = 8; //十进制，默认为int类型
		int y = 034; //八进制
		int z = 0x31; //十六进制
		long u = 2435645489L;
		long v = -2147483650L;
		System.out.println(x + " " + y + " " + z + " " + u + " " + v);*/
		
		String s = in.next();  //读取一个字符串，在空白符之前结束, '',\t,\n
		String s2 = in.next();
		String s3 = in.next();
		//String d = in.nextLine(); //读取一行，enter健结束
		System.out.println(s + ";" + s2 + ";" + s3);
		//System.out.println(d);
		
		/*double a =  (double)1 / 2;
		System.out.println(System.currentTimeMillis() + ";" + a);
		
		int c = 'A'; //ASCII 65
		int d = 'a'; //ASCII 97
		int e = 1; //ASCII 49
		System.out.println(c + ";" + d);*/
		int a = '1'; //ASCII 49
		System.out.println(a);
		
		
	}

}
