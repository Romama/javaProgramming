package interview.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过executorService创建多线程
 * @author Administrator
 * 线程池包括4个基本组成部分：
 * （1）线程池管理器-ThreadPool：用于创建并管理线程池，包括创建线程池、销毁线程池，添加新任务。
 * （2）工作线程-PoolWorker：线程池中线程，在没有任务时处于等待状态，可以循环地执行任务。
 * （3）任务接口-Task：每个任务必须实现的接口，以供工作线程调度任务的执行，
 *      它主要规定了任务的入口，任务执行完成后的收尾工作，任务的执行状态等。
 * （4）任务队列-taskQueue：用于存放没有处理的任务，提供一种缓冲机制。
 * 
 * T1：创建线程时间；T2：在线程中执行任务的时间；T3：销毁线程的时间。 
 * 如果 T1 + T3 远大于 T2，可以使用线程池，提高服务器性能。
 * 线程池正是关注如何缩短或调整T1，T3时间的技术，从而提高服务器性能的。
 * 它把T1、T3分别安排在服务器程序的启动和结束的时间段或者一些空闲的时间段，
 * 这样在服务器程序处理客户请求时，不会有T1、T3的开销了。
 * 
 * 线程池不仅调整了T1、T3产生的时间段，而且它还显著减少了创建线程的数目。
 * 假设一个服务器一天要处理50000个请求，并且每个请求需要一个单独的线程完成。
 * 在线程池中，线程数一般是固定的，所以产生线程总数不会超过线程池中线程的数目，而如果服务器不利用线程池技术
 * 来处理这些请求，则线程总数为50000。一般线程池大小是远小于50000。
 * 
 * Executors可以创建4中线程池，
 * newCachedThreadPool创建一个可缓存线程池，若线程池长度超过处理需要，可灵活回收空闲线程；若无可回收，则新建线程。
 * newFixedThreadPool创建一个定长线程池，可控制线程的最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务都按照执行顺序执行。
 * 
 */
public class ExecutorServiceToCreateMultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//定长线程池，可控制线程的最大并发数，超出的线程在队列中等待。
		ExecutorService pool = Executors.newFixedThreadPool(3); 
		for(int i = 0; i < 10;i++){ //三个线程
			final int index = i;
			pool.execute(new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						System.out.println(index); //内部类只能调用final定义的变量？？？
						Thread.sleep(2000); //睡眠2s
						
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}));
		}
	
		//具有缓存的多线程执行
		Executors.newCachedThreadPool().execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		//定长线程池，适用于定时及周期性任务的执行
		Executors.newScheduledThreadPool(3).execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		//单线程化的线程池
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
