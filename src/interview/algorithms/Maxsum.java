package interview.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一组字符串数组，每个字符串由A-J之间的任意个字符组成，给A-J之间的字符赋值后，每个字符串都可以看作是一个整数。如（ABC可以为987）
 * 假设A-J的值介于0-9之间，设计一种赋值方式，使得所有字符串之和最大。
 * @author WeiCuicui
 *
 */
public class Maxsum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //n行
        List<String> list = new ArrayList<String>();
        while(n > 0){
        	String buffer = in.nextLine();
        	if(!buffer.equals("\n") && !buffer.equals("")){ //回车
        		list.add(buffer);
        		n--;
        	}
        }
        
        System.out.println(list);
        System.out.println(maxSum(list));
	}
	
	public static int maxSum(List<String> list){
		int[] nums = new int[10]; //记录A-J在所有输入的字符串中出现的下标和
		int[] rules = {9,8,7,6,5,4,3,2,1,0};
		int[] values = new int[10]; //给字符赋值
		
		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			for(int j = 0; j < s.length(); j++){
				int index = s.charAt(j) - 'A';
				
				nums[index] = nums[index] + j + 1; //位置相加,位置从1开始
			}
		}
		
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		
		int[] backup = new int[nums.length]; //备份
		for(int i = 0; i < nums.length; i++){
			backup[i] = nums[i];
		}
		Arrays.sort(nums); //nums排序
		System.out.println();
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		
		int begin = 0;
		for(; begin < nums.length && nums[begin] == 0; begin++);
		
		int k = 0;
		int l = 0;
		
		//给字符赋值
		for(int i = begin; i < nums.length; i++){
			int times = nums[i];
			for(int j = 0; j < backup.length; j++){
				if(times == backup[j]){
					l = j;
					break;
				}
			}
			values[l] = rules[k++];
		}
		
		for(int i = 0; i < values.length; i++){
			System.out.print(values[i] + " ");
		}
		
		int maxSum = 0;
		
		for(int i = 0; i < list.size(); i++){
			int sum = 0;
			String s = list.get(i);
			for(int j = 0; j < s.length(); j++){
				int index = s.charAt(j) - 'A';
				sum = sum * 10 + values[index]; //下标相加
			}
			maxSum += sum;
		}
		return maxSum;
	}

}
