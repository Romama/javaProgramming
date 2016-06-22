package chapter21;

/**
 * 泛型方法
 * @author admin
 *
 */
public class GenericfMethodDemo {

	public static void main(String[] args){
		Integer[] nums = {2,4,1,2,4,45};
		String[] strs = {"ddd","jkj","uiuo","fjdl"};
		
		print(nums);
		print(strs);
	}
	
	public static <E> void print(E[] list){  //泛型方法
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
}