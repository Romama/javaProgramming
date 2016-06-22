package interview.algorithms;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 判断一组页面依次进入缓存过程中的未命中次数
 * @author WeiCuicui
 *
 */
public class PagesInCache {

	public static void main(String[] args){
		int maxSize = 9;
		int[] pages = {1,2,3,9,1};
		System.out.println(pagesNotFound(maxSize,pages));
	}

	/**
	 * 采用队列记录进入缓存的顺序，hashmap存储页面是否在缓存中
	 * @param maxSize 缓存最大空间
	 * @param pages  依次需要进入缓存的页面，存储的是页面的大小
	 * @return
	 */
	public static int pagesNotFound(int maxSize,int[] pages){
		if(maxSize <= 0 || pages == null || pages.length == 0)
			return 0;
		int remain = maxSize;
		int len = pages.length;
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < len; i++){
			int size = pages[i]; //页面大小
			if(map.containsKey(size) && map.get(size) > 0){ //命中
				continue;
			}
			else if(size <= remain && (!map.containsKey(size) || map.get(size) == 0)){//未命中，缓存未满，加入缓存
				count++;
				remain = remain - size;
				map.put(size,1);
				queue.add(size);
			}
			else if(size > remain && (!map.containsKey(size) || map.get(size) == 0)){ //未命中，缓存已满，则需要换出页面
				while(size > remain && !queue.isEmpty()){ //依次换出页面，直到有空间存储新的页面
					int headSize = queue.poll(); //出队列
					remain = remain + headSize;
					map.put(headSize, 0);
				}
				if(size > remain && queue.isEmpty()){//队列已经为空，但是空闲缓存仍然放不下当前页面，报错！
					return -1;
				}
				remain = remain - size;
				count++;
				map.put(size,1);
				queue.add(size);
			} 
		}
		return count;
	}
}
