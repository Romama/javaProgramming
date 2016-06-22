package chapter22;

import java.util.Stack;

public class QueueByStack {

	public Stack<Integer> s1 = new Stack<Integer>();
	public Stack<Integer> s2 = new Stack<Integer>();
	
	 // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);  //入栈都存入s1中
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(s1.isEmpty()){
        	while(!s2.isEmpty())
        		s1.push(s2.pop());
        }
        
        while(!s1.isEmpty()){ //先将s1中的全部导入到s2
        	s2.push(s1.pop());
        }
        
        s2.pop(); //栈顶出栈
        
        while(!s2.isEmpty()){
        	s1.push(s2.pop());//再全部放回到s1中
        }
    }

    // Get the front element.
    public int peek() {
	   if(s1.isEmpty()){
       while(!s2.isEmpty())
         s1.push(s2.pop());
       }
       
       while(!s1.isEmpty()){ //将s1中的全部导入到s2中
       	 s2.push(s1.pop());
       }
       
       int x = s2.peek(); //获取栈顶元素
       
       while(!s2.isEmpty()){
       	 s1.push(s2.pop());//再全部放回到s1中
       }
       
       return x;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
	
}
