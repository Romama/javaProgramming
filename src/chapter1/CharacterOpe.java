package chapter1;

/**
 * 字符操作
 * @author Administrator
 * byte,short,int,long,float,double,char,boolean八种基本数据类型
 * 基本数据类型是没有相应的操作方法什么的
 */
public class CharacterOpe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char c = 'd'; //c是基本数据类型变量
		Character d = 'd'; //d是character对象，是引用变量
		
		if(c == d)
			System.out.println(d + "; " + true);
		if(Character.isLetter(1)) //
		    System.out.println(Character.isLowerCase(c) + ";" + Character.isUpperCase(c) + ";");
				

	}

}
