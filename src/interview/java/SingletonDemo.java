package interview.java;

/**
 * 实现单例模式（只能生成该类的一个实例）
 * singleton
 * @author Administrator
 *
 */
public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//构造函数必须设置为private，禁止他人创建实例
	private SingletonDemo(){
		
	}
	
	
	//定义一个静态的实例，在需要的时候创建该实例
	private static SingletonDemo instance = new SingletonDemo();
	
	
	//公共的静态构造函数
	
}
