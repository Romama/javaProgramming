package interview.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 构成多边形的条件
 * @author WeiCuicui
 *
 */
public class PolygonCondition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
	    int n = in.nextInt(); //n行
	    int sum = 0; //木棍长度总和
	    int max = 0; //最大木棍长度
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//存储长度为l的木棍的数量
	  
	    while(n > 0){
	    	int op = in.nextInt();
	    	int num = in.nextInt();
	    	if(op == 1){ //插入木棍
	    		if(map.containsKey(num)){
	    			map.put(num, map.get(num) + 1);
	    		}else {
	    			map.put(num, 1);
				}
	    		sum = sum + num;
	    		if(num > max)
	    			max = num;
	    		if(sum - max > max){
	    			System.out.println("Yes");
	    		}else {
	    			System.out.println("No");
				}
	    			
	    	} else if(op == 2){ //移除木棍
	    		
	    		if(map.get(num) > 1){
	    			map.put(num, map.get(num) - 1);
	    		}else {
	    			map.remove(num);
				}
	    		sum = sum - num;
	    		max = Integer.parseInt(getMaxKey(map).toString());
	    		if(sum - max > max){
	    			System.out.println("Yes");
	    		}else {
	    			System.out.println("No");
				}
	    		
	    	} else {
	    		System.out.println("No");
			}
	    	n--;
	    }
	}
	
	//求Map中Key的最大值
    public static Object getMaxKey(HashMap<Integer, Integer> map) {
    	if(map == null || map.size() == 0)
    		return 0;
    	Set<Integer> set = map.keySet();
    	Object[] objects = set.toArray();
    	Arrays.sort(objects); //升序排列
    	return objects[objects.length - 1]; //输出最大值
    }

}
