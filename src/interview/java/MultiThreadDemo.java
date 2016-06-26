package interview.java;


/**
 * 实现4个线程，其中，两个线程对j执行加1运算，两个线程对j执行减1运算
 * @author Administrator
 *
 */
public class MultiThreadDemo {
	
	private int j;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultiThreadDemo multiDemo = new MultiThreadDemo();
		Inc inc = multiDemo.new Inc();//内部类，非静态，调用时需要先建立一个外部类的实例对象
		Dec dec = multiDemo.new Dec();
		for(int i = 0; i < 2; i++){
			Thread t = new Thread(inc);
			t.start();
			t = new Thread(dec);
			t.start();
		}
		
		Inner inner = new MultiThreadDemo.Inner(); //定义一个静态内部类的实例对象
	}
	
	public static class Inner{
		
	}
	
	private synchronized void inc(){ //同步方法
		j++;
		System.out.println(Thread.currentThread().getName() + "-inc" + j);
	}
	
	private synchronized void dec(){ //同步方法
		j--;
		System.out.println(Thread.currentThread().getName() + "-dec" + j);
	}
	
	class Inc implements Runnable{
		@Override
		public void run(){
			inc();
		}
	}
	
	class Dec implements Runnable{
		@Override
		public void run(){
			dec();		
		}
	}
}
