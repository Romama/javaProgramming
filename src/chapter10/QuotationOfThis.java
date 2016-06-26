package chapter10;

/**
 * this引用名
 * （1）用法一：指向调用对象本身；this给出一种指代对象的方法
 * （2）用法二：让构造方法调用同一个类的另一个构造方法
 * @author Administrator
 *
 */
public class QuotationOfThis {

	private int age = 0;
	private String name = "";
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setName(String name){ //使用this，指向调用对象本身
		this.name = name;
	}
	
	public QuotationOfThis(int age,String name){
		this.age = age;
		this.name = name;
	}
	
	public QuotationOfThis(){
		this(20, ""); //使用this调用另一个构造方法；this要放在其他语句之前出现
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
