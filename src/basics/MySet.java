package basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * java的集合框架：规则集中不允许存储重复元素
 * @author admin
 * collection接口是处理对象集合的根接口
 * set,hashset,不存在重复元素，集合中的元素没有特定的顺序。
 * linkedhashset,集合中的元素按照插入的顺序存储。
 *    如果不需要维护元素插入集合的顺序，最好使用hashset，因为它比linkedhashset更高效
 *    treeset有元素增加或删除时都会进行一次排序，默认升序排列
 */ 
public class MySet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * hashset 规则集中的元素是无序的
		 */
		Set<String> set1 = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		set.add("New York");
		set.add("London");
		set.add("Beijing");
		set.add("Shanghai");
		
		set.add("Beijing");
		
		
		set1.add("Beijing");
		set1.add("Shanghai");
		set1.add("Guangzhou");
		set1.add("Tianjin");
		set1.add("London");
		set1.add("New York");
		set1.add("Paris");
		
		System.out.println(set);
		
		//集合形式 [a,b,c,....]
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		
		//探究collection的方法
		set.remove("London");
		System.out.println(set);
		
		System.out.println(set.contains("Beijing"));
		
		set.addAll(set1);
		System.out.println(set);
		
		set1.removeAll(set);
		System.out.println(set1);
		
		set1.retainAll(set);
		System.out.println(set1);
		
		/**
		 * linkedhashset 规则集中的元素是按照元素插入顺序排列的
		 */
		LinkedHashSet<String> lSet = new LinkedHashSet<String>();
		lSet.add("london");
		lSet.add("beijing");
		lSet.add("shanghai");
		lSet.add("guangzhou");
		System.out.println(lSet);
		
		/**
		 * 树形集 treeset   规则集中的元素是有序的
		 */
		Set<String> myset = new HashSet<String>();
		myset.add("London");
		myset.add("Beijing");
		myset.add("Shanghai");
		myset.add("NewYork");
		
		//使用myset初始化treeset
		TreeSet<String> mytreeSet = new TreeSet<String>(myset);
		mytreeSet.add("Guangzhou");
		mytreeSet.add("Beijing"); //规则集中不允许存在重复元素
		System.out.println("Sorted tree set: "+mytreeSet);
		System.out.println("first: "+mytreeSet.first());
		System.out.println("headSet: "+mytreeSet.headSet("New York"));
		System.out.println("tailSet: "+mytreeSet.tailSet("Beijing"));
		
		System.out.println("lower: "+mytreeSet.lower("P"));   //严格小于p的最大者
		System.out.println("higher: "+mytreeSet.higher("P")); //严格大于p的最小者
	}

}