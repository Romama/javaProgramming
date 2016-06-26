package chapter1;

/**
 * StringBuffer与StringBuilder
 * 除了StringBuffer中修改缓冲区的方法是同步的（线程安全的）之外，StringBuffer与StringBuilder是很相似的。
 * 如果是多任务并发访问，就使用StringBuffer；而如果是单任务访问，使用StringBuilder会更有效。
 * @author Administrator
 *
 */
public class StringBuilderAndStringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		sb.append("oaha"); //在尾部追加
		sb.append(2);
		sb.append(new char[]{'d','e','f'},0,2); //建立一个匿名数组new char[]{'d','e','f'}
		System.out.println(sb.toString());
		
		sb.delete(0, 2); //删除部分元素
		sb.deleteCharAt(1);
		System.out.println(sb.toString());
		
		sb.insert(2, 'p'); //在指定位置插入元素
		sb.insert(3, true);
		System.out.println(sb.toString());
		
		sb.replace(0, 3, "78979"); //用特定字符串替换特定的子串
		System.out.println(sb.toString());
		
		sb.reverse(); //颠倒字符串生成器中的字符
		System.out.println(sb.toString());
		
		sb.setCharAt(0, 'm'); //除了该方法的返回值为void，上面的其它方法的返回值均为stringBuilder的引用
		System.out.println(sb.toString());
		
	}

}
