package interview.java;

/**
 * 利用线程同步和线程调度技术，模拟发牌程序
 * @author Administrator
 *
 */
public class CardMultiThread {

	public static void main(String[] args){
		CardBuffer buffer = new CardBuffer(); //定义缓冲区
		Send send = new Send(buffer, 52); //定义发牌线程，共52张牌
		send.setPriority(10); //设置为最高优先级
		send.start();
		for(int i = 0; i < 4; i++){ //四个取牌线程
			Receive receive = new Receive(buffer, i);
			receive.start();
		}
	}
}

class Send extends Thread{
	private CardBuffer buffer;
	private int count; //发牌数量
	public Send(CardBuffer buffer,int count){
		this.buffer = buffer;
		this.count = count;
	}
	public void run(){
		for(int i = 0; i < count; i++){
			buffer.put(i);
		}
	}
}

class Receive extends Thread{ //取牌线程类
	private CardBuffer buffer;
	private int order;//约定取牌线程的次序
	public Receive(CardBuffer buffer,int order){
		this.buffer = buffer;
		this.order = order;
	}
	public void run(){
		while(true){
			buffer.get(this.order);
		}
	}
	
}

class CardBuffer{
	private int value;
	private boolean isEmpty = true; //value是否为空的信号量
	private int order = 0; //信号量，约定取牌线程的次序
	synchronized void put(int i){
		while(!isEmpty){ //缓冲池的数据尚未取走
			try {
				this.wait(); //阻塞自己
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		this.value = i;
		System.out.println("send: " + i);
		isEmpty = false;
		notifyAll(); //唤醒其它所有等待线程
	}
	
	synchronized int get(int order){
		while(isEmpty || this.order != order){ //当value为空或者取牌顺序不符时等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		isEmpty = true;
		notifyAll();
	    this.order = (this.order + 1) % 4; //加1，使取牌顺序轮转
		System.out.println("receive: " + value);
		return value;
	}
}