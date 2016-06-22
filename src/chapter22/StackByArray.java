package chapter22;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 借用数组实现堆栈
 * @author Administrator
 *
 */
public class StackByArray {

	public static void main(String[] args){
		
		Stack1<Integer> stack1 = new Stack1<Integer>();
		stack1.push(2);
		stack1.push(4);
		stack1.push(3);
		
		stack1.pop();
		stack1.pop();
		
		Stack2<Integer> stack2 = new Stack2<Integer>(10);
		stack2.push(5);
		stack2.push(6);
		stack2.push(7);
		stack2.push(8);
		
		stack2.pop();
		
	    int len1 = stack1.getSize();
	    int len2 = stack2.getElementCount();
		
		System.out.println(len1 + " " + stack1.peek() + "\n" );
		
		for (int i = 0; i < len1; i++) {
			System.out.print(stack1.pop() + " ");
		}
		
		System.out.println("\n" );
		
		System.out.println(len2 + " " + stack2.peek() + " " + stack2.isEmpty() + " " + stack2.isFull()  + "\n");
		
		for (int i = 0; i < len2; i++) {
			System.out.print(stack2.pop() + " ");
		}
	}
}

/**
 * based on arraylist
 * 基于泛型和ArrayList
 * @author Administrator
 *
 */
class Stack1 <T>{
	//arraylist具有随机存取元素的特点，顺序表，实现堆栈
	List<T> list = new ArrayList<T>(); 
	
	public int getSize(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void push(T o){
		list.add(o);
	}
	
	public T peek(){
		return list.get(getSize() - 1);
	}
	
	public T pop(){
		T o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
}

class Stack2 <T>{
	private int maxSize;
	private int top; //栈顶
	private T[] data; //泛型不能直接定义数组：T[] elements = new T[capacity];是非法的。但是，可以这样： T[] elements = (T[])new Object[capacity];
	
	public Stack2(int maxSize){ //构造函数
		this.maxSize = maxSize;
		data = (T[])new Object[maxSize];
		top = -1;
	}
	
	public int size(){
		return maxSize;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return maxSize == top + 1;
	}
	
	public T peek(){
		if(isEmpty())
			return null;
		return data[top];	
	}
	
	public int getElementCount(){
		return top + 1;
	}
	
	public void push(T o){
		if(isFull()){
			T[] tmp = (T[])new Object[maxSize * 2];
			for(int i = 0 ;i < getElementCount() - 1; i++){
				tmp[i] = data[i];
			}
			maxSize = 2 * maxSize;
			data = tmp;
		}
		data[++top] = o;
	}
	
	public T pop(){
		if(isEmpty())
			return null;
		T o = data[top--];
		return o;
	}
}