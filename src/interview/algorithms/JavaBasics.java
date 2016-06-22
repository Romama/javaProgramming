package interview.algorithms;

import interview.java.JavaBasic;

//封装、继承、抽象、多态。父类或接口定义的引用变量可以指向子类或者实现类的实例对象，引用变量，实例对象。

/*public class JavaBasics {

	public static void main(String[] args){
		byte b = -128; //byte在计算机中是以补码的形式存储的，-128到127之间
		int a = 'a';  //字符可以转换为整形
		short c = 255;
		c = (short)(c + 1); //c + 1运算会自动提升表达式的类型为int，所有这里会报编译错误
		c += 1;//java编译器会对它进行特殊处理，因此不会编译出错
		//floor向下取整，round是四舍五入，即将原来的数+0.5后再向下取整
		System.out.println(Math.round(-11.5) + "," + Math.floor(-11.5)); 
		System.out.println(a + ";" + b + ";" + c);
		String username = null;
		if("abd".equals(username)){
			System.out.println(username);
		}
	}
}

interface inter{
	public static final int a = 0;
	public int getA();
	public void setA(int a);
}*/

/*public abstract class JavaBasics{
	public static void main(String[] args){
		JavaBasics jb = new JavaBasics(2,3) { //定义匿名内部类，即在定义父类的子类的同时，定义子类的实例对象。
			
			@Override
			public int getC() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		System.out.println(jb.c);
	}
	public static int b = 0;
	public int c = 1;
	public JavaBasics(int b,int c){
		this.b = b;
		this.c = c;
	}
	public int getB(){
		return b;
	}
	public void setB(int b){
		this.b = b;
	}
	public abstract int getC();
}*/

public class JavaBasics{
	public static void main(String[] args){
		int i = 1;
		System.out.println(new JavaBasics().test(i));
	}
	
	public int test(int i){
		try{
			System.out.println("fun1");
			return i;
		    
		} finally{
			System.out.println("fun2" + i);
			i++; //此时虽然i++，但是try中返回的值已经暂存了，是1，所有finally执行完之后，return的仍然是1	
			System.out.println("fun2" + i);
			return i;
		}
	}
}