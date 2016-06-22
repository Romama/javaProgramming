package interview.java;

/**
 * 由于getClass()在Object类中定义成了final，子类不能覆盖该方法
 * @author Administrator
 *
 */
public class GetClass extends JavaBasic{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GetClass().test();
		String s = "1,2,3,4,5,6,7,8,9";
	}
	
	public void test(){
		
		System.out.println(super.getClass().getSuperclass().getName()); //得到父类的名称
	}

}

