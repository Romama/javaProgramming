package basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;




/**
 * 线性表list：允许存储重复元素
 * 下面这两个类是实现list接口的两个具体类：：
 * 数组线性表类：ArrayList
 * 链表：LinkedList
 * @author admin
 *
 */
public class MyList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testArrayAndLinkedlist();
		
	}
	
	public static void testArrayAndLinkedlist(){
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1, 11);
		list.add(3, 14);
		
		System.out.println(list);
		
		LinkedList<Object> linkedList = new LinkedList<Object>(list);
		
	}

}