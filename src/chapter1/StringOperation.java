package chapter1;


/*
 * 关于字符串的相关操作
 */

public class StringOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		initialString();
		stringOpe();
		toArray();
	}
	
	//string定义及初始化
	public static void initialString(){
		
		//java中对具有相同字符串序列的字符串直接量使用同一个实例，因此 s1=s2，因为二者是同一个对象
		//但是，s1 != s2，因为二者是不同的对象
		String s1 = "welcome";
		String s2 = new String("welcome");
		String s3 = "welcome";
		String s4 = "WelCome";
		
		if(s1.regionMatches(0, "wel", 0, 3))
			System.out.println("true");
		else {
			System.out.println("false");
		}
		
		if(s1.startsWith("wel"))
			System.out.println("true");
		else {
			System.out.println("false");
		}
		
		if(s1 == s2)
			System.out.println("true");
		else {
			System.out.println("false");		
		}
		
		if(s1 == s3)
			System.out.println("true");
		else {
			System.out.println("false");
		}
		
		if(s1.equalsIgnoreCase(s4))
			System.out.println("true");
		else {
			System.out.println("false");
		}
		
		if(s1.compareTo(s2) == 0 )
			System.out.println("true");
		else {
			System.out.println("false");
		}
	}
	
	//string的替换，string的子串
	public static void stringOpe(){
		String s1 = "898JKJUkdwhj";
		String s2 = "juieOPUO";
		String s3 = "nmbmUI78";
		System.out.println(s1.substring(2,5) + ";" + s1.toLowerCase());
		System.out.println(s1.replace('d', 'a') + "; " + s3.replaceFirst("m", "0"));
		
	}
	
	//string转换为数组与数组转换为string
	public static void toArray(){
		String s = "yiyj7jhj";
		char[] array = new char[s.length()];
		array = s.toCharArray();
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		s = "08087hdj";
		s.getChars(0, s.length() - 1, array, 0);
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		
		System.out.println(String.valueOf(array));
	}

}
