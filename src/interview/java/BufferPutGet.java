package interview.java;

/**
 * 采用信号量和同步方法使得发送线程和接收线程同步运行
 * @author Administrator
 *
 */
public class BufferPutGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Buffer buffer = new Buffer();
		Sender sender = new Sender(buffer);
		Receiver receiver = new Receiver(buffer);
		sender.start();
		receiver.start();
	}

}

class Buffer{ //缓冲区
	private int value; //共享变量
	private boolean isEmpty = true;   //缓冲区是否为空的信号量
	public synchronized void put(int i){ //在方法上加缓存
		while(!isEmpty){
			try {
				this.wait();  //若buffer中的数据尚未取走，阻塞自己
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		this.value = i; //缓冲区为空，将value放入
		isEmpty = false; //设置value为不空状态
		notify();  //唤醒其它等待线程
	}
	public synchronized int get(){
		while(isEmpty){
			try {
				this.wait();  //若buffer中的数据为空，阻塞自己，等待放入数据
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		isEmpty = true;
		notify();
		return this.value;
	}
}

class Sender extends Thread{ //发送者线程
	private Buffer buffer;
	public Sender(Buffer buffer){
		this.buffer = buffer;
	}
	public void run(){
		for(int i = 1; i < 6; i++){  //连续向缓冲区发送若干数据
			buffer.put(i);
			System.out.println("Sender put " + i);
			/*try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}*/
		}
	}
}

class Receiver extends Thread{ //接收线程类
	private Buffer buffer;
	public Receiver(Buffer buffer){
		this.buffer = buffer;
	}
	public void run(){
		for(int i = 1; i < 6; i++){ //连续从缓冲区接收若干数据
			System.out.println("Receiver get: " + buffer.get());
			/*try{
				sleep(1);
			}catch(InterruptedException e){
				e.printStackTrace();
			}*/
		}
	}
}
