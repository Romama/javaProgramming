package interview.java;

/**
 * 抽象类
 * @author Administrator
 * 不能有抽象的构造方法、抽象的静态方法，因为这两者是无法被继承的
 * 
 */
public abstract class AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s = "ddd";
		s.substring(0,1); // substring是全部小写的
		System.out.println(s.substring(0,0));
	}	
}
