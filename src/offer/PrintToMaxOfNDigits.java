package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印1到最大的n位数
 * 大数据要借助字符串来实现
 * @author Administrator
 *
 */
public class PrintToMaxOfNDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(printMaxN(2));
	}
	
	/**
	 * 打印1到最大的n位数
	 * 用字符串表示整数
	 * 什么时候停止在number上加1呢？当最高位，及number[1]位置相加有进位到number[0]时结束
	 * @param n
	 * @return
	 */
	public static List<String> printMaxN(int n){
		List<String> list = new ArrayList<String>();
		char[] number = new char[n]; //存储一个n位数
		//n位数的每一位都初始为0
		for(int i = 0; i < n; ++i)
			number[i] = '0';
		while(!increment(number)){
			print(list, number);
		}
		
		return list;
	}
	
	/**
	 * number + 1
	 * @param number
	 * @return
	 */
	public static boolean increment(char[] number){
		boolean isOverflow = false; //初始设置没有溢出
		int nTakeOver = 0; //前一位到该位的进位
		int len = number.length; 
		//
		for(int i = len - 1; i >= 0; --i){
			int nSum = number[i] - '0' + nTakeOver; //本位值
			if(i == len - 1) //若为最后一位，则加1
				nSum++;
			if(nSum >= 10){
				if(i == 0)
					isOverflow = true;
				else {
					nSum = nSum - 10;
					nTakeOver = 1;
					number[i] = (char)(nSum + '0');
				}
			} else { //无进位，结束循环
				number[i] = (char)('0' + nSum); //char可以直接转换为int，但是int转换为char时则需要强制转换
				break;
			}
		}
		
		return isOverflow;
	}
	
	/**
	 * 打印number，并将number转为字符串
	 */
	public static void print(List<String> list,char[] number){
		int i = 0;
		int len = number.length;
		for(i = 0; i < len && number[i] == '0'; ++i);
		StringBuilder sb = new StringBuilder(String.valueOf(number));
		
		sb = sb.replace(0, i, " "); //0 到 i - 1之间的数替换为空
		list.add(sb.toString());
		
	}

}
