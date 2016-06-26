package interview.java;

/**
 * 线程同步方式
 * sleep()与wait()
 * @author Administrator
 */
public class MultiThreadSynchronized {

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
			synchronized (MultiThreadSynchronized.class) {
				System.out.println("enter thread 1");
				System.out.println("thread 1 is waiting");
				
				try{
					MultiThreadSynchronized.class.wait(); //同步锁.wait()
					Thread.sleep(100); //sleep(100)是一个静态方法,Thread.sleep(100)
				} catch(InterruptedException e) {
					e.printStackTrace(); //输入异常
				}
				System.out.println("Thread 1 is going on");
				System.out.println("Thread 1 is being over");
			}
		}
	}
	
	//线程二
	private static class Thread2 implements Runnable{
		
		@Override
		public void run(){
			synchronized (MultiThreadSynchronized.class) { //将MultiThread.class作为锁
				System.out.println("enter Thread 2");
				System.out.println("thread 2 notify other thread can release wait status..");
				MultiThreadSynchronized.class.notify(); //等到notify后面的语句都执行完成后，才会释放同步锁
				System.out.println("thread 2 is sleeping ten millisecond..");
				try{
					Thread.sleep(10); // 睡眠10毫秒
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Thread 2 is going on");
				System.out.println("Thread 2 is being over");
				
			}
		}
	}
}
