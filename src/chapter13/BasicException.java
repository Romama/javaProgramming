package chapter13;

import java.util.Scanner;

/**
 * 基本的异常处理情况
 * @author Administrator
 * throws 声明一个异常，对于那些必检异常，一定要声明异常，否则编译无法通过
 * throw new exception() 抛出一个异常对象，一般在try中抛出，类似于方法调用，此时，若在catch中找到匹配的异常，则执行catch中的异常处理语句
 * catch(FileNotFoundException e)捕获异常，执行完catch中的语句后，会继续执行catch后的语句。
 */
public class BasicException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		boolean continueInput = true;
		do{
			try{
				int a = in.nextInt();
				if(a < 10)
					throw new RomaException();
				continueInput = false;
			}catch(RomaException e){
				System.out.println(e.toString());
				//in.nextLine(); //discard input
			}
			
			System.out.println("hahahahahaha");
		}while(continueInput);
		
	}
}

/**
 * throwable 是所有异常类的根，其下又分为 Exception 和  error两个类型的异常
 * error 由java虚拟机抛出，内部系统错误，这种错误很少发生，一旦发生，除了通知用户以及终止程序之外，几乎什么也不能做。
 * exception 由程序和外部环境引起的错误，这种错误能被程序捕获和处理。
 * runtimeException，运行时异常，由java虚拟机抛出，它描述的是程序设计错误。
 * 
 * 其中，runtimeExcetion 和  error以及它们的子类异常都是免检异常。其它异常都是必检异常，即编译器会强制程序员检查并处理它们。
 * 
 * 免检异常一般反应的是程序设计上不可恢复的错误。
 * 
 * 自定义的异常类,必须继承及throwable
 * @author Administrator
 *
 */
class RomaException extends Throwable{
	public String toString(){
		return "the number should be greater than 10!";
	}
}
