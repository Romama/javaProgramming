package chapter21;

/**
 * 利用数组Array来实现堆栈Stack
 * @author admin
 *
 */
public class GenericStackByArray<T> {
	int maxSize;
	int top = -1;
	Object[] data;
	
	public int getSize(){
		return maxSize;
	}
	
	public int getElementCount(){
		return top;
	}
	
	public boolean isEmpty(){
		 return top == -1;
	}
	
	public boolean isFull(){
		return top + 1 == maxSize;
	}
	
	//判断栈是否已满，如果已经满了，则扩大数组长度
	public boolean push(T o){
		if(isFull())
			System.out.println("栈已满");
		
		this.data[++top] = data;
		return true;
	}
	
	public T pop() throws Exception{
		if(isEmpty())
			throw new Exception("栈已空");
		return (T)data[top--];
	}
	
	public T peek(){
		return (T)data[getElementCount()];
	}
}