package chapter1;


/**
 * 求两个数的最大公约数
 * @author Administrator
 *
 */
public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getGcd(20, 4));
	}
	
	//欧几里得原理求最大公约数
	public static int getGcd(int a,int b){
		if(a % b == 0)
			return b;
		else 
			return getGcd(b, a % b);
	}

}
