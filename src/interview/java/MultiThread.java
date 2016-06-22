package interview.java;

/**
 * 线程相关
 * @author Administrator
 * Java中有两种方法可以实现一个线程：继承Thread类与实现Runnable接口
 */
public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new Thread1()).start(); //启动thread1,start后，执行线程的run方法
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		new Thread(new Thread2()).start(); //启动thread2
	}
	
	//线程一
	private static class Thread1 implements Runnable{
		
		@Override
		public void run(){
			synchronized (MultiThread.class) {
				System.out.println("enter thread 1");
				System.out.println("thread 1 is waiting");
				try{
					MultiThread.class.wait();
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace(); //输入异常
				}
				System.out.println("Thread 1 is going on");
				System.out.println("Thread 1 is being over");
			}
		}
	}
	
	//实现runnable接口，实现多线程
	private static class Thread2 implements Runnable{
		
		@Override
		public void run(){
			synchronized (MultiThread.class) { //将MultiThread.class作为锁
				System.out.println("enter Thread 2");
				System.out.println("thread 2 notify other thread can release wait status..");
				MultiThread.class.notify(); //等到notify后面的语句都执行完成后，才会释放同步锁
				System.out.println("thread 2 is sleeping ten millisecond..");
				try{
					Thread.sleep(10);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Thread 2 is going on");
				System.out.println("Thread 2 is being over");
				
			}
		}
	}
}
