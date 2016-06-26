package offer;

/*
 * 两个有序数组A1和A2，相同顺序排列
 * A1中有足够的空间来容纳A2，现在请将A2中的元素移动到A1中，并使得A1中的所有元素有序排列
 */
public class MergeTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a1 = new int[20];
		a1[0] = 3;
		a1[1] = 5;
		a1[2] = 10;
		a1[3] = 12;
		int[] a2 = new int[5];
		a2[0] = 2;
		a2[1] = 6;
		a2[2] = 7;
		a2[3] = 9;
		a2[4] = 14;
		
		a1 = merge(a1, a2, 4, 5);
		for(int i = 0; i < 9; i++)
			System.out.print(a1[i] + " ");
		
	}
	//从尾到头扫描a2，a1，将两者中较大者放在a1中合适的位置上
	public static int[] merge(int[] a1,int[] a2,int len1,int len2){
		int i = len1 - 1;
		int j = len2 - 1;
		int k = len1 + len2 - 1;
		while(i >= 0 && j >= 0){
			if(a1[i] > a2[j]){
				a1[k--] = a1[i--];
			} else if(a1[i] <= a2[j]){
				a1[k--] = a2[j--];
			}
		}
		while(i >= 0)
			a1[k--] = a1[i--];
		while(j >= 0)
			a1[k--] = a2[j--];
		
		return a1;
	}

}
