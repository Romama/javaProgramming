package interview.java;


/**
 * 取款线程类
 * @author Administrator
 *
 */
public class Fetch extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//保证了数据的完整性与一致性，但是，由于并发线程执行顺序是不唯一的，
		//所有根据线程的执行顺序不同，输出结果也是不同的
		Account account = new Account("roma");
		Save save = new Save(account, 100);
		Save save2 = new Save(account, 2000);
		Fetch fetch = new Fetch(account, 500);
		save.start();
		save2.start();
		fetch.start();
	}
	
	private Account account; //账户
	private double value; //取款金额
	public Fetch(Account account,double value){ 
		this.account = account;
		this.value = value;
	}
	public void run(){
		synchronized (this.account) {//保证了数据的完整性与一致性，但是，由于并发线程执行顺序是不唯一的
			double balance = account.getBalance();
			
			System.out.println(this.account.getName() + "账户：现有" + balance 
					+ "取走：" + this.account.get(value) + "当前余额：" + this.account.getBalance()); 
		}
	}

}
