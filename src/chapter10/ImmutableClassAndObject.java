package chapter10;


/**
 * 定义一个不可变类，并从这个类定义一个不可变对象
 * 不可变类满足3个条件
 * （1）所有数据域都是private
 * （2）没有修改器setter
 * （3）对于访问器getter，不能返回指向可变数据库的引用
 * 
 * @author Administrator
 *
 */
public class ImmutableClassAndObject {

	private int age = 1;
	
	private String name = "Roma"; //String 是不可变类
	
	public ImmutableClassAndObject(){
		
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ImmutableClassAndObject object = new ImmutableClassAndObject();
		System.out.println(object.getAge() + " " + object.getName());
	}

}
