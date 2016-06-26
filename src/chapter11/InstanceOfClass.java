package chapter11;



/**
 * 基本数据类型之间可以进行强制类型转换；
 * 类类型也可以进行强制类型转换。
 * @author Administrator
 *
 */
public class InstanceOfClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object o = new InstanceOfClass(); //可以运行，因为所有类都是Object类型的子类
		//这样会报错，因为java编译器不能自动识别出o是InstanceOfClass的类型，必须进行强制转换
		InstanceOfClass b = (InstanceOfClass)o; 
		
		//如果一个对象不是student类的实例，就不能将其转换为student类的变量
		//因此，一个好的经验是，在尝试转换之前，确保源对象是目标类的实例，这可以使用运算符instanceOf来实现
		if(o instanceof InstanceOfClass){
			System.out.println("it is true");
		}
	}
}
