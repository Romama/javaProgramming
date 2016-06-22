package interview.java;


/**
 * 内部类
 * @author Administrator
 *
 */
public class InnerClass {
	
	private int level = 1;
	
	private static int group = 2;

	public static void main(String[] args){
		InnerClass ob1 = new InnerClass();  //先建立外部类的对象
		InnerClass.test1 ob2 = ob1.new test1();  //通过外部类对象ob1定义内部类ob2
		System.out.println(ob2.getAge() + "," + ob2.getName());
		
		InnerClass.test2 ob3 = new InnerClass.test2();//静态内部方法
		System.out.println(ob3.getGrade() + ob1.level);
	}
	
	//非静态内部类
	public class test1{
		int age = 5 + level + group; //非静态内部类完全可以访问包含类的成员
		String name = "roma";
		public void setAge(int age){
			this.age = age;
		}
		public int getAge(){
			return age;
		}
		
		public void setName(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
	}
	
	//静态内部类
	public static class test2 {
		public int grade = 100 + group; //静态内部类，只能访问包含类的静态成员
		public void setGrade(int grade){
			this.grade = grade;
		}
		public int getGrade(){
			return grade;
		}
	}
	
	//匿名内部类
	/*new test2({
			
	});*/
	
}
