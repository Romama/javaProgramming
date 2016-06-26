package offer;

import java.util.HashMap;

/**
 * 求字符串中第一个仅出现一次的字符
 * @author WeiCuicui
 *
 */
public class FirstOnlyOnceCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "djwj247dkj";
		int index = getFirstOnlyOnce(s);
		if(index != -1){
			System.out.println(s.charAt(index));
		} else {
			System.out.println("不存在");
		}
	}
	
	//求字符串中第一个仅出现一次的字符
	public static int getFirstOnlyOnce(String s){

		//记录每个字符的出现次数
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){ //第一次遍历，统计每个字符出现的次数
			char tmp = s.charAt(i);
			if(map.containsKey(tmp))
				map.put(tmp, map.get(tmp) + 1);
			else {
				map.put(tmp, 1);
			}
		}
		
		for(int i = 0; i < s.length(); i++){//第二次遍历，查找第一个仅出现一次的字符
			char tmp = s.charAt(i);
			if(map.containsKey(tmp) && map.get(tmp) == 1)
				return i;
		}
		
		return -1;
	}

}
