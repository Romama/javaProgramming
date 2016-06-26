package chapter13;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 输入的值不匹配，抛出异常并进行异常处理
 * @author Administrator
 *
 */
public class InputMismatchExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		boolean isContinue = true;
		do{
			try{
				int x = in.nextInt();
				System.out.println(x);
				isContinue = false;
			} catch(InputMismatchException e){
				System.out.println("the input mismatch");
				
				//丢弃当前的输入行，用户可以键入新的行
				in.nextLine(); 
			}
	
		}while(isContinue);
	}

}
