package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 删除ArrayList中重复的元素
 * 元素类型是String
 * @author Perfecter
 */
public class RemoveDuplicated {

	public static void main(String[] args) {
		RemoveDuplicated instance = new RemoveDuplicated();
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("33");
		list.add("11");
		list.add("22");
		list.add("1234");
		list.add("44");
		list.add("1234");
		list.add("55");
		list.add("66");
		list.add("33");
		list.add("22");
		list.add("88");
		list.add("99");
		list.add("44");
		list.add("11");
		list.add("22");
		list.add("123");
		list.add("1234");
		System.out.println("输入字符串数组：");
		for (String ele : list) {
			System.out.print(ele + " ");
		}
	    //instance.remove(list);
	    instance.remove_map(list);
		/*Set<String> result = instance.remove_set(list);
		System.out.println("\n去除重复元素：\n" + result);*/
	    System.out.println("\n去除重复元素：");
		for (String ele : list) {
			System.out.print(ele + " ");
		}
	}
	//删除ArrayList中的重复元素，排序
	public List<String> remove(List<String> list){
		if(list != null && list.size() > 0){
			Collections.sort(list);
			System.out.println("\n排序：");
			for (String ele : list) {
				System.out.print(ele + " ");
			}
			int i = 0,j = 1;
			while(j < list.size()){
				if(list.get(i).equals(list.get(j)))
					list.remove(j);
				else{
					i = j;
					++j;
				}
			}
		}
		return list;
	}
	
	//利用hashmap，删除重复元素
	public List<String> remove_map(List<String> list){
		if (list != null && list.size() > 0) {
			Map<String, Integer> map = new HashMap<String,Integer>();
			int i = 0;
			while(i < list.size()){
				String ele = list.get(i);
				if (map.get(ele) == null){
					map.put(ele, 1);
					++i;
				} else {
					list.remove(i);
				}
			}
		}
		return list;
	}
	
	//set中元素是不可重复的，利用hashset去重
	public Set<String> remove_set(List<String> list){
		Set<String> set = new HashSet<String>();
		if(list != null && list.size() > 0){
			for (String s : list) {
				set.add(s);
			}
		}
		return set;
	}
}
