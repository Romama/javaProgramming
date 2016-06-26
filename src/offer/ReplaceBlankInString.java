package offer;

public class ReplaceBlankInString {

	//将字符串s中的空格用 %20替换，不使用库函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "we are family";
		System.out.println(replaceStr(s));
		//直接使用string库函数里的replace方法
		System.out.println(s.replace(" ", "%20"));
	}
	
	//将字符串中的空格用 %20替换，时间复杂度为O(n)
	public static String replaceStr(String s){
	
		//字符串s除了空格外的实际字符长度
		int initialLen = 0;
		int numOfBlank = 0;
		int len = s.length();
		
		//这里的 len = s.length(),++i都是优化代码效率的表现
		for(int i = 0; i < len; ++i){
			char c = s.charAt(i);
			if(c != ' ')
				++initialLen;
			else {
				++numOfBlank;
			}
		}
		int newLen = initialLen + numOfBlank * 3;
		
		//存放替换后的字符串
		char[] newArray = new char[newLen];
		
		//在原来字符串的尾部增加空格，扩充长度
		System.arraycopy(s.toCharArray(), 0, newArray, 0, len);

		//从尾至头，遍历newArray，将出现的空格都用%20替换
		//定义两个指针
		int i = len - 1;
		int j = newLen - 1;
		while(i >= 0 && j >= 0){
			if(newArray[i] == ' '){
				newArray[j--] = '0';
				newArray[j--] = '2';
				newArray[j--] = '%';
				i--;
			}else{//移动元素
				newArray[j--] = newArray[i--];
			}
		}
		
		return String.valueOf(newArray);
	}

}
