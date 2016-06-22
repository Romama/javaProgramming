package chapter22;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * java集合框架
 * @author Administrator
 * 如果不需要维护元素插入时的顺序，建议使用HashSet，它比linkedhashset更加高效
 */
public class CollectionFramework {

	//程序必须有main方法且具有 args参数才能运行
	public static void main(String[] args){
		
		System.out.println("HashSet\n");
		testHashSet();
		
		System.out.println("\n\nLinkedHashSet\n");
		testLinkedHashSet();
		
		System.out.println("\n\nTreeSet");
		testTreeSet();
	}
	
	//散列集 hashset
	public static void testHashSet(){
		//hashset中的元素是无序的
		Set<String> set = new HashSet<String>();
		set.add("Beijing");
		set.add("London");
		set.add("Paris");
		set.add("London");
		set.add("Washington");
		
		System.out.println("直接输出set：" + set);
		
		System.out.println("通过iterator迭代器遍历set：");
		//通过迭代器遍历set集合
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		
		set.remove("London");
		System.out.println("\n将set转换为object数组后再遍历输出：");
		//将set集合转换为数组形式后再遍历
		Object[] objects = set.toArray();
		for(int i = 0; i < objects.length; i++){
			if(i == objects.length - 1)
			    System.out.print(objects[i]);
			else
				System.out.print(objects[i] + ",");
		}
	}
	
	//LinkedHashSet
	public static void testLinkedHashSet(){
		//LinkedHashSet中的元素是按照元素插入时的顺序存储的
		Set<String> set = new LinkedHashSet<String>();
		set.add("Beijing");
		set.add("London");
		set.add("Paris");
		set.add("London");
		set.add("Washington");
		
		System.out.println("直接输出set：" + set);
		
		System.out.println("通过iterator迭代器遍历set：");
		//通过迭代器遍历set集合
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		
		
		System.out.println("\n将set转换为object数组后再遍历输出：");
		//将set集合转换为数组形式后再遍历
		Object[] objects = set.toArray();
		for(int i = 0; i < objects.length; i++){
			if(i == objects.length - 1)
			    System.out.print(objects[i]);
			else
				System.out.print(objects[i] + ",");
		}
	}
	
	//treeset
	public static void testTreeSet(){
		Set<String> set = new HashSet<String>();
		set.add("Beijing");
		set.add("London");
		set.add("Washington");
		set.add("Tokyo");
		set.add("Paris");
		set.add("New York");
		
		TreeSet<String> treeSet = new TreeSet<String>(set);
		System.out.println("Sorted tree set: " + treeSet + "\n");
		
		System.out.println("first(): " + treeSet.first());
		System.out.println("last()：" + treeSet.last());
		//<
		System.out.println("headset: " + treeSet.headSet("London"));
		//>
		System.out.println("tailset: " + treeSet.tailSet("London"));
		
		System.out.println("lower(\"p\")：" + treeSet.lower("P"));
		System.out.println("higher(\"p\")：" + treeSet.higher("P"));
		System.out.println("floor(\"p\")：" + treeSet.floor("P"));
		System.out.println("ceiling(\"p\")：" + treeSet.ceiling("P"));
		System.out.println("pollFirst(\"p\")：" + treeSet.pollFirst());
		System.out.println("pollLast(\"p\")：" + treeSet.pollLast());
		System.out.println("new Tree set: " + treeSet);
		
		
	}
}