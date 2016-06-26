package chapter1;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 用目标字符串替换文件中的特定字符串
 * @author Administrator
 *
 */
public class ReplaceText {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String instruction = in.nextLine();//接收输入的命令行
		String[] strArrays = instruction.split(" "); //从命令行中提取文件名、替换字符串
		String srcFile = strArrays[2];
		String desFile = strArrays[3];
		String oldStr = strArrays[4];
		String newStr = strArrays[5];
		replace(srcFile, desFile, oldStr, newStr);
	
	}
	
	/**
	 * 字符串替换
	 * @param srcFile
	 * @param desFile
	 * @param oldStr
	 * @param newStr
	 */
	public static void replace(String srcFile,String desFile,String oldStr,String newStr) throws Exception{
 
		File src = new File(srcFile); //建立源文件的file对象
		if(!src.exists()){ //源文件不存在
			System.out.println("srcFile does not exist!");
			System.exit(0);
		}
	
		//若文件已经存在，则文件内容将被废弃；若不存在，则新建文件
		PrintWriter writer = new PrintWriter(desFile); //新建目标文件，并可以向该文件中写数据
		Scanner reader = new Scanner(src); //阅读器
		String content = "";
		while(reader.hasNext()){
			content = reader.nextLine();
			content = content.replace(oldStr, newStr); //替换一行
			writer.println(content); //向目标文件中写一行
			System.out.println(content);
		}
		
		writer.close();//关闭书写器
		reader.close();//关闭写文件
	}

}
