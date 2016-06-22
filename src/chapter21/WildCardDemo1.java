package chapter21;

public class WildCardDemo1 {

	public static void main(){
		GenericStack<Integer> s1 = new GenericStack<Integer>();
		GenericStack<Object> s2 = new GenericStack<Object>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		
		s2.push("rtt");
		s2.push("355");
		s2.push("90809");
		
		merge(s1, s2);
		WildCardDemo.print(s2);
		
	}
	
	//合并数组
	public static <T> void merge(GenericStack<T> s1,GenericStack<? super T> s2){
		if(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}
}
