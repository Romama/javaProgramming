package chapter1;

/**
 * 采用二分查找算法，查找特定元素x，若存在，返回下标，若不存在，返回应该插入的位置
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {4,7,9,10,24,38,45};
		int key = 80;
		System.out.println(binarySearch(array, key));
	}
	
	public static int binarySearch(int[] array,int key){
		if(array == null || array.length == 0){
			return -1;
		}
		
		int low = 0,high = array.length - 1;
		while(low <= high){ //循环条件是 low <= high
			int mid = (low + high) / 2;
			if(array[mid] == key)
				return mid;
			else if(array[mid] > key)
				high = mid - 1;
			else {
				low = mid + 1;
			}
		}
		return low;
	}

}
