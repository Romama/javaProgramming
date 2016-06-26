package chapter1;

import java.util.Date;


/**
 * 静态变量、方法
 * @author Administrator
 *
 */
public class StaticAndNotStatic {

	final static int numOfObjects = 3; // final用来定义一个常量
	int nums;
	public static int getNumOfObjects(){ // 在静态方法中不能调用非静态变量
		
		return numOfObjects;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long milliSeconds = System.currentTimeMillis();
		Date date = new Date(milliSeconds);
	    Date de = new Date();
		System.out.println(date.toString() + "; " +"; " + milliSeconds + " ; "+ de.getTime() ); //gettime获得的就是毫秒数
		
		double a = Math.random() * 10;
		char c = (char)('a' + Math.random() * ('z' - 'a' + 1));
		System.out.println(a + " ; " + c + " ; " );
		
		int aa = StaticAndNotStatic.numOfObjects; //通过类直接访问静态变量
		StaticAndNotStatic test = new StaticAndNotStatic(); 
		System.out.println(test.nums + " : " + aa); //通过实例调用非静态变量
	}

}
