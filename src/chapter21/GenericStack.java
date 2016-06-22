package chapter21;

import java.util.ArrayList;

/**
 * 定义泛型类：栈
 * @author admin
 * 使用arraylist实现栈
 */
public class GenericStack <T> {  //泛型类

	ArrayList<T> list = new ArrayList<T>();
	
	
	public int getSize(){
		return list.size();
	}

	public T peek(){
		return list.get(getSize() - 1);
	}
	
	public void push(T t){
		list.add(t);
	}
	
	public T pop(){
		T t = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return t;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
}