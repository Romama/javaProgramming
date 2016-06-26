package chapter11;

/**
 * super的使用
 * @author Administrator
 * 1 子类继承它的父类中所有可访问的数据域和方法，它能继承构造方法吗？
 *   答：子类是不继承父类的构造方法的。但是，在任何情况下，构造一个类的实例时，将会调用沿着继承链的所有父类的构造方法。
 *     当构造一个子类的对象时，子类构造方法会在完成自己的任务之前，首先调用它的父类的构造方法。如果父类继承自其它类，
 *     那么父类构造方法又会在完成自己的任务之前，调用它自己的父类的构造方法。这个过程持续到整个继承体系中最后一个构造方法被调用为止，
 *     这就是构造方法链。
 * 2 父类的构造方法能够从子类中调用吗？
 *   答：可以，使用super关键字即可。
 * 3 关键字super是指这个super出现的类的父类，关键字super可以用于两种途径：（1）调用父类的构造方法（2）调用父类的方法。
 *   且super（），super（parameters）必须放在构造方法中的第一条语句。
 * 4 若一个类被显式定义了有参构造方法，它就不具有默认的无参构造方法了。
 */
public class Super extends Child{

	public Super(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		System.out.println("haha");
	}
}

//Child是Super的父类
class Child {
	public Child(String s){
		
	}
}
