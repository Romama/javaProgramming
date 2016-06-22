package basics;

import java.util.Scanner;


/**
 * 二维数组：矩阵
 * @author admin
 *
 */
public class Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//定义二维数组
		int[][] matrix = {{1,2,3},{4,5,6},{7,8}};
		int[][] triangleArray=new int[5][];
		triangleArray[0] = new int[5];
		triangleArray[1] = new int[4];
		triangleArray[2] = new int[3];
		triangleArray[3] = new int[2];
		triangleArray[4] = new int[1];
		System.out.println(matrix.length);
		for (int[] is : matrix) {
			System.out.println(is.length);
			for (int i : is) {
				System.out.print(i);
			}
		}
		initialMatrix();
	}

	//初始化矩阵
	public static void initialMatrix(){
		
		// 一、通过输入值初始化矩阵
		int[][] matrix = new int[3][2];
		Scanner input = new Scanner(System.in);
		System.out.println("请输入"+matrix.length+"行"+matrix[0].length+"列的二维数组");
		//赋值
		for(int i = 0;i < matrix.length;i++)
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = input.nextInt(); 
			}
		//输出
		for(int i = 0;i < matrix.length;i++)
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
		
		// 二、使用随机值初始化数组
		//赋值
		for(int i = 0;i < matrix.length;i++)
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = (int)( Math.random() * 100); 
			}
		System.out.println();
		//输出
		for(int i = 0;i < matrix.length;i++)
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}		
	}
}