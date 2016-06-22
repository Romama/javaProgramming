package chapter21;

public class TestIntegerMatrix {

	public static void main(String[] args){
		Integer[][] m1 = new Integer[][]{{1,2,3},{1,0,2},{0,3,2}};
		Integer[][] m2 = new Integer[][]{{0,3,2},{4,3,1},{1,0,3}};
		
		//create an instance of IntegerMatrix
		IntegerMatrix matrix = new IntegerMatrix();
		
		System.out.println("\nm1 + m2 is : ");
		GenericMatrix.printResult(m1, m2, matrix.addMatrix(m1, m2), '+');
		
		System.out.println("\nm1 * m2 is : ");
		GenericMatrix.printResult(m1, m2, matrix.multiplyMatrix(m1, m2), '*');
	}
}