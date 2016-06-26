package chapter10;

import java.util.ArrayList;


/**
 * 设计堆栈类
 * @author Administrator
 *
 */
public class DesignStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericStack<String> stack = new GenericStack<String>();
		stack.push("Roma");
		stack.push("Rose");
		System.out.println(stack.size() + " ;" + stack.isEmpty());
		
		stack.pop();
		System.out.println(stack.size() + " ;" + stack.isEmpty());
		stack.pop();
		System.out.println(stack.size() + " ;" + stack.isEmpty());
	}

}

//定义一个泛型类，模拟栈
class GenericStack<E>{
	private ArrayList<E> list = new ArrayList<E>();
	
	public int size(){
		return list.size();
	}
	
	public E peek(){
		return list.get(list.size() - 1);
	}
	
	public E pop(){
		E o = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return o;
	}
	
	public void push(E o){
		list.add(o);
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
}
