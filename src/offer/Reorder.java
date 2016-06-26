package offer;

/**
 * 调整数组顺序，使奇数位于偶数前面。
 * 要注意可扩展性，提取出一个共有模式
 * @author Administrator
 *
 */
public class Reorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {2,6,8,7,1,3,5,0};
		reorder(a);
		for(int i = 0,len = a.length; i < len; ++i)
			System.out.print(a[i] + " ");
	}
	
	/**
	 * 调整数组顺序，使得所有奇数位于偶数前面
	 * @param a
	 * @return
	 */
	public static int[] reorder(int[] a){
		int len = a.length;
		int i = 0;
		int j = len - 1;
		while(i < j){
			while(i < j && func(a[j]))
				--j;
			while(i < j && !func(a[i]))
				++i;
			if(i < j){
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		return a;
	}
	
	//判断一个数是不是偶数
	public static boolean func(int a){
		return (a & 1) == 0;
	}

}
