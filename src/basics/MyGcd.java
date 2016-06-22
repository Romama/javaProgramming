package basics;

/**
 * 求最大公约数
 * @author admin
 *
 */
public class MyGcd {
	
	public static void main(String[] args){
		System.out.println(getGcd(100,140));
		
		//找两个数的最大公约数的比较有效的方法
		System.out.println(getGCD(300, 45));
	}

	/**
	 * 一般方法求得最大公约数
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int getGcd(int num1,int num2){
		int gcd=1;
		int k=2;
		
		//n的除数不可能大于n/2
		while(k <= num1 / 2 && k <= num2 / 2){
			if(num1 % k == 0 && num2 % k == 0){
				gcd=k;
			}
			k++;
		}
		return gcd;
	}  
	
	/**
	 * 欧几里得方法求最大公约数，时间复杂度为O(logn)
	 * gcd(m,n)表示m和n的最大公约数，若 m % n == 0,则最大公约数为n，否则，最大公约数为gcd(n,m % n)
	 * 递归运算，求最大公约数
	 * @param num1
	 * @param num2
	 * @return
	 */	
	public static int getGCD(int num1,int num2){
		
		if(num1 % num2 == 0)
			return num2;
		else {
			return getGcd(num2, num1 % num2);
		}	
	}			  				
}