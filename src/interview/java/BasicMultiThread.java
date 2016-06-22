package interview.java;

/**
 * 两种创建线程的方式：继承Thread类（不适用于多重继承） 和 实现Runnable接口
 * （实现了该接口的对象a并不是线程对象，而是线程对象的目标对象，还需要创建Thread对象 = new Thread(a)）
 * @author Administrator
 * 
 */
public class BasicMultiThread {

	public static void main(String[] args) { //主线程
		// TODO Auto-generated method stub
		System.out.println("currentThread="+Thread.currentThread().getName()); //输出当前线程对象名
		//创建了两个线程对象
		NumberThread thread_odd = new NumberThread("奇数线程",1);
		NumberThread thread_even = new NumberThread("偶数线程",2);
		
		thread_even.setPriority(10);
		
		//调用start()方法启动这两个线程对象后，分别执行各自的run()方法中的线程体。
		//而且线程的启动顺序不能决定线程的执行顺序
		thread_odd.start();
		thread_even.start();
		
		
		//输出结果是：先输出activeCount，再输出两个奇数线程和偶数线程的内容，说明main线程要先于其它线程执行。
		System.out.println("activeCount="+Thread.activeCount());//输出当前活动线程数
		
		//NumberThread1本身不是一个线程对象，它作为一个线程对象的目标对象来使用。
		NumberThread1 odd = new NumberThread1(1);
		//因此，还需要声明一个Thread线程对象，当线程启动后，执行的是目标对象的run()方法
		Thread odd1 = new Thread(odd, "奇数线程1");
		odd1.start();
		//输出结果是：先输出activeCount，再输出两个奇数线程和偶数线程的内容，说明main线程要先于其它线程执行。
	    System.out.println("activeCount="+Thread.activeCount());//输出当前活动线程数
		
		//建立thread的匿名线程对象
		new Thread(new NumberThread1(2), "偶数线程1").start();
		//输出结果是：先输出activeCount，再输出两个奇数线程和偶数线程的内容，说明main线程要先于其它线程执行。
		System.out.println("activeCount="+Thread.activeCount());//输出当前活动线程数
		
		
		
	}
	
	//静态内部类，继承thread，实现多线程
	public static class NumberThread extends Thread{ //Thread类本身是实现了Runnable接口的
		private int first;  //序列初值
		public NumberThread(String name,int first){ //thread中有构造方法 Thread(String name)
			super(name);
			this.first = first;
		}
		public NumberThread(String name){
			this(name,0); //对象自身，对象是通过构造函数初始化的
		}
		public void run(){ //线程3，覆盖thread的run()
			System.out.println("\n" + this.getName() + "开始");
			for(int i = first; i < 50; i = i + 2){
				System.out.println(i + " ");
			}
			System.out.println("\n" + this.getName() + "结束");
		}
	}
	
	//实现Runnable接口，定义线程,runnable接口中没有name属性
	public static class NumberThread1 implements Runnable{
		private int first;
		public NumberThread1(int first){
			this.first = first;
		}
		public NumberThread1(){
			this(0);
		}
		public void run(){
			System.out.println("runnable 开始！ ");
			for(int i = first; i < 50; i = i + 2)
				System.out.println(i + " ");
			System.out.println("runnable 结束！");
		}
	}
}
