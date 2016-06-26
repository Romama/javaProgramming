package chapter1;

/**
 * 十进制转十六进制
 * @author Administrator
 *
 */
public class DecimalToHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 1;
		System.out.println(decimalToHex(x));
	}
	
	//求十六进制表示
	public static String decimalToHex(int d){
		String result = "";
		while(d != 0){
			int c = d % 16;
			result = getCharacter(c) + result;
			d = d / 16;
		}
		return result;
	}
	
	//十六进制 0-9，abcdef，对应十进制的0-15
	public static char getCharacter(int x){
		if(x >= 0 && x <= 9){
			return (char)(x + '0');
		} else {
			return (char)(x - 10 + 'a');
		}
	}

}
