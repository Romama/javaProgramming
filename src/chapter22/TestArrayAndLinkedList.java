package chapter22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Array 和  LinkedList
 * @author Administrator
 *
 */
public class TestArrayAndLinkedList {

	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>(); //顺序表
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(0,10);
		list.add(3,30);
		System.out.println("a list of integers in the array list ");
		System.out.println(list);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println("\n" + queue);
	}
}