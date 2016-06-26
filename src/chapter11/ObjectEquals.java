package chapter11;

/**
 * object的equals方法
 * 测试两个对象是否相等,== 检测两个引用变量是否指向同一个对象。
 * 
 * ==用来比较两个基本数据类型的变量的值是否相同，或者两个对象是否具有相同的引用
 * 若要比较两个对象的内容是否相同，需要在对象的类定义中覆盖equals方法，使用equals(Object o)，
 * 而不能使用equals(Student s)这种具体的类。
 * 
 * @author Administrator
 *
 */
public class ObjectEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//覆盖Object类中的equals方法
	public boolean equals(Object o){
		if(o instanceof ObjectEquals)
			System.out.println("true");
		else {
			System.out.println("false");
		}
		return true;
	}

}
