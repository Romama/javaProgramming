package interview.java;


/**
 * 编写多线程，实现主线程和子线程循环执行
 * 子线程首先循环10次，接着main线程循环100次，然后子线程循环10次，接着主线程循环100次......
 * 如此循环50次
 * @author Administrator
 *
 */
public class MultiThreadDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadDemo1 demo1 = new MultiThreadDemo1(); //由于线程类是定义在内部变量中的，因此首先要定义对象

		for(int i = 0; i < 2; i++){
		    Haha haha = demo1.new Haha(); 
			haha.start();
		}
	}
	
	public class Haha extends Thread{ //子线程、主线程写在一起
		public synchronized void child(){
			for(int i = 0; i < 10; i++) //循环10次
				System.out.print(i + " ");
			System.out.println();
		}
		public synchronized void main(){
			for(int i = 0; i < 100; i++) //循环100次
				System.out.print(i + " ");
			System.out.println();
		}
		public void run(){ //定义执行的顺序
			child();
			main();
		}
	}
}
