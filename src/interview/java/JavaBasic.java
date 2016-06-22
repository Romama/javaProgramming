package interview.java;

public class JavaBasic {

	public static void main(String[] args){
		loopOut();
		System.out.println(Math.round(11.5) + "," + Math.round(-11.5)); //+0.5之后向下取整
		System.out.println(Math.ceil(11.5) + "," + Math.ceil(-11.5)); //向上取整
		System.out.println(Math.floor(11.5) + "," + Math.floor(-11.5)); //向下取整
		
		String s = "asd";
		String d = "asd";
		System.out.println(s.equals("asd"));
		System.out.println(s.equals(d)); //可能空指针，交换一下顺序
	}
	
	//跳出当前的多重循环
	public static void loopOut(){
		
		//方式一
		ok: //做标记
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++){
				if(j == 5){
					System.out.println("i=" + i + ",j=" + j + ",hahahaha");
					break ok;
				}	
			}
	
	    //方式二
	    int[][] arr = {{1,2,3},{4,5,6,7},{9}};
	    boolean found = false; //定义变量，使得外层的循环条件受里层代码的控制
	    for(int i = 0; i < arr.length && !found; i++)
	    	for(int j = 0; j < arr[i].length; j++){
	    		if(arr[i][j] == 5){
	    			System.out.println("i=" + i + ",j=" + j + ", hehehe");
	    			found = true;
	    			break;
	    		}
	    	}
	}
	
	//java强制类型转换
	public static void shortType(){
		short s1 = 1;
		s1 = (short)(s1 + 1); //强制类型转换
		s1++;
		float a = (float)1.6;//java中默认的浮点类型为double，默认的整型为int
		short s2 = 3;
		long l = 4;
		//当get中形参类型是基础类型时可以，但是当形参的类型为封装类型时，就是不可以的，就必须强制转换为Integer或Long的基础类型。
		get(s1); 
	}
	
	public static int get(int a){
		return a;
	}
}
