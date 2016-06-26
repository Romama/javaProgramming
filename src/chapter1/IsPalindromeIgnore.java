package chapter1;

/**
 * 忽略掉非数字、字母的字符，判断给定的字符串是否是回文串
 * @author Administrator
 *
 */
public class IsPalindromeIgnore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "*(234jukuyk*(kyukuj4)(3)";
		System.out.println(isAnagramIgnore(s));
		System.out.println(isAnagramIgnore1(s));
	}
	
	//忽略非数字、字母，剩余其它字符，是否是回文串
	public static boolean isAnagramIgnore(String s){
		char[] array = s.toCharArray();
		
		int i = 0,j = array.length - 1;
		while(i < j){
			while(i < j && !Character.isLetterOrDigit(array[i]))
				i++;
			while(i < j && !Character.isLetterOrDigit(array[j]))
				j--;
			if( i < j && array[i] != array[j])
				return false;
			i++;j--;
		}
		
		return true;
	}
	//方法二：利用stringBuilder的reverse()方法
	public static boolean isAnagramIgnore1(String s){
		char[] array = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = 0,j = array.length - 1;
		for(; i <= j; i++){
			if(Character.isLetterOrDigit(array[i]))
				sb.append(array[i]);
		}
		String s1 = sb.toString(); //暂存排除非数字、字母后的字符串s
		return s1.equals(sb.reverse().toString()); //利用stringBuilder的reverse()进行逆置
	}

}
