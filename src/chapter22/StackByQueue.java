package chapter22;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Administrator
 * 使用两个队列实现堆栈
 * 算法始终保持有一个队列是空的
 * 
 * 队列不具备随机存取元素的特点！
 * queue，即链式线性表
 */
public class StackByQueue {
	
	    private Queue<Integer> queue1 = new LinkedList<Integer>();
		private Queue<Integer> queue2 = new LinkedList<Integer>();
		
		 // Push element x onto stack.
	    public void push(int x) {
	    	if(!queue1.isEmpty()){ //定义queue1为非空
	    	    queue1.add(x);
	    	}
	    	
	    	else{
	    		queue2.add(x);
	    	}
	       
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        if (queue1.isEmpty()) {   
				while(!queue2.isEmpty()){
				    queue1.add(queue2.poll());
				}
			} 
			while(queue1.size() > 1){ //将queue1中最后加入的元素留下，其余元素转移到queue2中
			    queue2.add(queue1.poll());
			}
			
			queue1.poll(); //出栈，后入先出
	    }

	    // Get the top element.
	    public int top() {
	        if (queue1.isEmpty()) {
				while(!queue2.isEmpty()){
				    queue1.add(queue2.poll());
				}
			} 
			while(queue1.size() > 1){ //将queue1中最后加入的元素留下，其余元素转移到queue2中
			    queue2.add(queue1.poll());
			}
			
			queue2.add(queue1.peek()); //取栈顶元素，queue1中留下的最后一个元素，转移到queue2中
			return queue1.poll();  //移除queue1中仅剩的元素，将queue1清空
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return queue1.isEmpty() && queue2.isEmpty();
	    }
}
