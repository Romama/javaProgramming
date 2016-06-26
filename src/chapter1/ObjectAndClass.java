package chapter1;

import java.util.Date;
import java.util.Random;

/**
 * 对象和类
 * @author Administrator
 *
 */
public class ObjectAndClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		System.out.println(date.getTime() + "; " + date.getDay() + "; " + date.getHours() + "; " + date.getMinutes());
	
		System.out.println(new Random().nextInt() + ";" + new Random().nextInt(5));
		ObjectAndClass[] objs = new ObjectAndClass[10]; // 定义一个对象数组，该数组中的所有元素的初始值为null
		for(int i = 0; i < objs.length; i++)
		   System.out.println(objs[i] + " ");
	}

}
