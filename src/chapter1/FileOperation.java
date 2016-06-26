package chapter1;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 * 文件类的操作
 * @author Administrator
 * File类包含许多获取文件属性的方法以及重命名和删除文件的方法，但是，File类不包含读写文件内容的方法。
 * 
 * 在文件系统中，每个文件都存放在一个目录下，绝对文件名 = 文件名 + 它的完整路径 + 驱动器字母组成。
 * 
 * （1）构建一个File实例，并不会在机器上创建一个文件，不管文件是否存在，都可以创建任意文件名的File实例，
 * 可以调用File实例上的exists()方法来判断这个文件是否存在。
 * （2）printwriter可以创建一个文件，并且向文件中写数据。printwriter writer = new printwriter("filename");
 * （3）scanner可以从文件中读取数据。scanner reader = new Scanner(new File("filename"));
 * 
 * 
 */
public class FileOperation {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		File file = new File("my/a.txt"); //斜杠是目录分隔符
		System.out.println("Does it exist? " + file.exists());
		System.out.println("the file has  " + file.length() + " bytes");
		System.out.println("Can it be read ?  " + file.canRead());
		System.out.println("Can it be written ? " + file.canWrite());
		System.out.println("Is it a directory ? " + file.isDirectory()); //是否是一个目录
		System.out.println("Is it a file ? " + file.isFile());
		System.out.println("Is it absolute ? " + file.isAbsolute()); //使用绝对路径名创建一个File
		System.out.println("Is it hidden? " + file.isHidden());
		System.out.println("Absolute path is  " + file.getAbsolutePath()); //获取绝对路径
		System.out.println("Last modified on   " + new Date(file.lastModified())); //最后更改日期
		
		//fileWriteData(); //创建文件，并向文件中写内容
		fileReader();
		
		//scanner的工作方式
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(); //读取一个整数，以默认分隔符 空格为结束
		String s = in.nextLine(); //读取一个以行分隔
		
		
	}
	
	//向文件中写内容，从文件中读内容
	public static void fileWriteData() throws Exception{
		File file = new File("scores2.txt"); //新建文件对象
		if(file.exists()){ //若文件存在
			System.out.println("File already exists");
			System.exit(0);
		}
		
		//create a file 
		PrintWriter output = new PrintWriter(file); //必须显式地声明异常，使用printWriter对象向文件中写入数据
		
		//write formatted output to the file
		output.println("Roma");
		output.println("90");
		output.println("cuicui");
		output.println("100");
		
		//close the file
		output.close(); //写数据结束后，必须关闭output，否则文件无法保存
	}
	
	//使用Scanner读数据
	public static void fileReader() throws Exception{
		File file = new File("scores.txt");
		
		if(!file.exists()){
			System.out.println("file not exists");
			System.exit(0);
		}
		//为了从文件读数据，必须为文件创建一个scanner对象
		Scanner input = new Scanner(file); //创建一个扫描器,从特定文件读取数据
		while(input.hasNext()){
			String firstName = input.next(); //
			int score = input.nextInt(); //读取分数
			System.out.println(firstName + " " + " " + score);
		}
		
		input.close(); //没有必要关闭输入文件，但这样做是释放被文件占用资源的好方法
	}
}
