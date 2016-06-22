package interview.algorithms;

/**
 * 给定一个字符串，求字符串中最长回文子串的长度（不要求连续）
 * @author WeiCuicui
 *
 */
public class LongestPalindromeSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="adccdf";
		String s = longestPalindrome(str);
		System.out.println(s);

	}
	
	//计算字符串的最长回文子串
	private static String longestPalindrome(String str){
		int n = str.length();
		if(str == ""){
			return "";
		}
		String longest = str.substring(0, 1); //初始化最长回文串
		for(int i = 0;i < n - 1;i++){
			String p1 = expandAroundCenter(str,i,i);  //第一种回文串情形： cac
			if(p1.length() > longest.length()){
				longest = p1;
			}
			String p2 = expandAroundCenter(str,i,i + 1); //第二种回文串情形：caac
			if(p2.length() > longest.length()){
				longest = p2;
			}
		}
		return longest;		
	}
	
	/**
	 * 中心向两边扩展法
	 * @param str
	 * @param l 左
	 * @param r 右
	 * @return
	 */
	private static String expandAroundCenter(String str,int l,int r){
		int n = str.length();		
		while(l >= 0 && r <= n - 1 && str.charAt(l) == str.charAt(r)){
			l--;
			r++;
		}		
		/**
		 * 这里要注意,c++中的str.substr(beginIndex,length)的后一个参数是从beginIndex开始的长度，		
		 * 而java中的str.substring(beginIndex,endIndex)的后一个参数是一个下标，应不小于beginIndex，并且在获取的字符串中,不包括该下标。
		 */
		return str.substring(l + 1, r);		
	}
}
