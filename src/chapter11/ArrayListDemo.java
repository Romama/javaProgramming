package chapter11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//数组ArrayList
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		list.add(2,0);
		list.set(0, 2);
		System.out.println(list.size() + " ; " + list.isEmpty() + " ; " + list + " ; " +
				list.lastIndexOf(2) + " ; " + list.indexOf(2) + " " + list.get(0) );
	}

}
