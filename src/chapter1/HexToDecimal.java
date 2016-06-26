package chapter1;

/**
 * 十六进制转换为十进制
 * @author Administrator
 *
 */
public class HexToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String h = "23f";
		System.out.println(getDecimal(h));
	}
	
	public static int getDecimal(String h){
		int result = 0;
		for(int i = 0; i < h.length(); i++){
			char c = h.charAt(i);
			result = 16 * result + toInt(c); 
		}
		
		return result;
	}
	
	public static int toInt(char c){
		if(c >= '0' && c <= '9')
			return c - '0';
		else {
			return c - 'a' + 10;
		}
	}

}
