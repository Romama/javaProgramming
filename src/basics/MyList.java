package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		List<User> users = new ArrayList<User>();
		User u1 = new User("aa", 20);
		User u2 = new User("bb", 22);
		users.add(u1);
		users.add(u2);
		users.sort(new UserComparator());
		System.out.println(users);
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1, 11);
		list.add(3, 14);
	    list.sort(new Comparator<Integer>(){
	    	@Override
	    	public int compare(Integer a,Integer b){
	    	  if(a > b)
	    		return 1;
	    	  else if(a < b)
	    		return -1;
	    	  else {
				return 0;
			  }
	    	}
		});
	    
		System.out.println(list);
		LinkedList<Object> linkedList = new LinkedList<Object>(list);
	}
}

class User{
	String name;
	int age;
	public User(String name,int age){
		this.name = name;
		this.age = age;
	}

	public String toString(){
		return "name is " + name + ", age is " + age;
	}
}
class UserComparator implements Comparator<User>{
	@Override
	public int compare(User a,User b){
		if(a.age > b.age){
			return 1;
		}else if(a.age < b.age){
			return -1;
		}else {
			return 0;
		}
	}
	
}