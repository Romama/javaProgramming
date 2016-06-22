package interview.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵、蛇形矩阵（2016腾讯笔试）
 * @author Administrator
 */
public class SpiralArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		System.out.println(spiralOrder(matrix));
	}
	
	//顺时针打印矩阵，按照螺旋形状，直到将所有元素遍历完为止
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
        	return result;
        int m = matrix.length; //行
        int n = matrix[0].length; //列
        
        //从左上角开始遍历 x=0,y=0
        int x = 0; 
        int y = 0;
        while(m > 0 && n > 0){
            //if one row/column left, no circle can be formed
            if(m == 1){
                for(int i = 0; i < n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            } else if(n == 1){
                for(int i = 0; i < m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
            //top - move right
            for(int i = 0;i < n - 1;i++){ //最上方的一行
                result.add(matrix[x][y++]);
            }
            //right - move down
            for(int i = 0;i < m - 1;i++){ //最右方的一列
                result.add(matrix[x++][y]);
            }
            //bottom - move left
            for(int i = 0;i < n - 1;i++){
                result.add(matrix[x][y--]);
            }
            //left - move up
            for(int i = 0;i < m - 1;i++){
                result.add(matrix[x--][y]);
            }
            
            //每次遍历完一个环后，更新下一个环的起始点 x++，y++，即下一个对角线上的位置
            x++; //下次要遍历到的行
            y++; //下次要遍历到的列
            m = m - 2; //剩余行数
            n = n - 2; //剩余列数
        }
        return result;
    }
}
