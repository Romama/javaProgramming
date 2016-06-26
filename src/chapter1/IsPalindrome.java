package chapter1;

/**
 * 检测一个字符串是否是回文串
 * @author Administrator
 *
 */
public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "anagrammarga";
		System.out.println(isAnagram(s));
	}
	
	public static boolean isAnagram(String s){
		for(int i = 0,j = s.length() - 1; i < j; i++,j--){
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		
		return true;
	}

}
