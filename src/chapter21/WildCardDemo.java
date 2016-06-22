package chapter21;

/**
 * 通配泛型：?;? extends T;? super T三种类型
 * ?相当于 ? extends object
 * 其中，T是某个泛型类型
 * @author admin
 *
 */
public class WildCardDemo {

	public static void main(String[] args){
		GenericStack<Integer> stack = new GenericStack<Integer>();
		
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		print(stack);
		
	}
	
	//打印输出
	public static void print(GenericStack<?> s){
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}
	}
}