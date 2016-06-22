package interview.java;

/**
 * 个人账户类
 * @author Administrator
 *
 */
public class Account {

	private String name;  //储户姓名
	private double balance;   //账户余额
	public Account(String name){ //新建账户，存款初始为0
		this.name = name;
	}
	public String getName(){ //返回账户名
		return name;
	}
	public double getBalance(){ //查看账户余额
		return balance;
	}
	public void put(double value){ //存款操作
		if(value > 0)
			this.balance += value;
	}
	public double get(double value){ //取款操作，参数为取款额，返回实际取到金额
		if(value > 0 && this.balance >= value){
			this.balance -= value;
			return value;
		} else if(value > 0 && this.balance < value){
			value = this.balance;
			this.balance = 0;
		}
		return value; //返回取到金额
	}

}
