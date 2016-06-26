package chapter1;

/**
 * 数组的复制
 * @author Administrator
 *
 */
public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {2,3,4,1,5,7};
		int[] b = {8,9,10,4,6,8};
		//使用for循环复制数组
		for(int i = 2; i < 4; i++){
			b[i] = a[i];
		}
		
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("print the array b: ");
		for(int i = 0; i < b.length; i++){
			System.out.print(b[i] + " ");
		}
		
		//使用system.arraycopy(srcarray,srcpos,desarray,despos,len);复制数组
		System.arraycopy(a, 4, b, 0, 2);
		
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("print the array b: ");
		for(int i = 0; i < b.length; i++){
			System.out.print(b[i] + " ");
		}
	}

}
