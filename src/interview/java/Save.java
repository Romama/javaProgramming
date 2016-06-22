package interview.java;


/**
 * 存款线程类
 * @author Administrator
 *
 */
public class Save extends Thread{

	private Account account;  //账户
	private double value; //存款金额
	public Save(Account account,double value){
		this.account = account;
		this.value = value;
	}
	public void run(){
		synchronized (this.account) {
			double balance = this.account.getBalance(); //查看账户余额
			
			this.account.put(this.value);
			System.out.println(this.account.getName() + "账户：现有" + balance + 
					"，存入" + value + "，余额" + account.getBalance());
		}
	}

}
