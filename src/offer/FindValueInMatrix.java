package offer;

import java.util.Scanner;

/**
 * 矩阵中元素按照行升序、列升序存在，
 * 给定一个value值，判断这个value值是否在矩阵中存在
 * @author Administrator
 *
 */
public class FindValueInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		//初始化矩阵
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; ++i){
			for(int j = 0; j < n; ++j){
				matrix[i][j] = in.nextInt();
			}
			//in.nextLine(); //丢弃之前输入的行
		}
		//输出刚才输入的矩阵
		for(int i = 0; i < m; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.print(hasValue(matrix, 5));
	}
	
	/**
	 * 是否存在这样的值
	 * @return
	 */
	public static boolean hasValue(int[][] matrix,int value){
		
		boolean flag = false;
		if(matrix != null){
			int m = matrix.length; //行
			int n = matrix[0].length; //列
			
			int i = 0, j = n - 1;
			
			//找规律，从右上角元素key开始遍历矩阵，若key > value，则key所在列均比value大，可以排除ke所在列
			//若key < value，则key所在行均比value小，可以排除key所在行
			while(i < m && j >= 0){
				int key = matrix[i][j];
				if(value < key){
					--j;
				} else if(value > key){
					++i;
				} else{
					flag = true;
					break;
				}
			}
		}
		
		return flag;
	}

}
