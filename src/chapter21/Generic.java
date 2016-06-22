package chapter21;

import java.util.ArrayList;
import java.util.Date;



/**
 * 泛型：参数化类型的能力
 * 可以定义带泛型类型的类或方法
 * @author WCC
 * 使用泛型的优点：能够在编译时而不是运行时就检测出错误
 * 泛型类型只存在于“编译”阶段，在运行时被消除。因此，如何使用泛型类型是有一些限制的
 * 例如：不能使用 E a = new E; 不能使用 E[] aa = new E[capacity]; 在静态环境中不允许类的参数是泛型类型; 异常类不能是泛型
 */
public class Generic {

	public static void main(String[] args){
		
		System.out.println(Max.max(2, 3));
		//System.out.println(Max.max(2, "ddd")); //运行时才能看到错误
		//System.out.println(Max1.max(33, "dkdjk")); 编译时就报错
		
		//定义两个泛型类型，但是在运行时只有一个ArrayList类加载到JVM中
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		System.out.println(list1 instanceof ArrayList);
		//System.out.println(list2 instanceof ArrayList<Integer>); //报错，因为 ArrayList<Integer>在运行时是不存在的
		
		ArrayList dates = new ArrayList();
		dates.add(new Date());
		//Date date = dates.get(0);
		Date date = (Date)dates.get(0);
		//dates.add("dddd");
		
		ArrayList<Date> dates2 = new ArrayList<Date>();
		dates2.add(new Date());
		//dates2.add("ddjk");
		Date date1 = dates2.get(0);
		
	}
}

/**
 * 求两者中的最大值
 * @author admin
 * 存在安全隐患
 */
class Max{
	public static Comparable max(Comparable c1,Comparable c2){
		if(c1.compareTo(c2) > 0)
			return c1;
		else {
			return c2;
		}
	}
}

/**
 * 使用泛型类型
 * @author admin
 * 不存在安全隐患
 */
class Max1{
	public static <E extends Comparable<E>> E max(E e1,E e2){
		if(e1.compareTo(e2) > 0)
			return e1;
		else {
			return e2;
		}
	}
}