package chapter1;

import java.util.List;

/**
 * 忽略字母的大小写，统计各个字母出现的次数
 * @author Administrator
 *
 */
public class IgnoreCaseCharacterStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] array = {'a','c','E','W','Q','A','C','e','w'};
		int[] result = characterStatistics(array);
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
	
	//统计字母出现的次数
	public static int[] characterStatistics(char[] array){
		int[] statistics = new int[26];
		for(int i = 0; i < array.length; i++){
			char c = array[i];
			statistics[Character.toLowerCase(c) - 'a']++; //统一转换为小写字母后统计出现次数
		}
		return statistics;
	}

}
