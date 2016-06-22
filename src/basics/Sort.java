package basics;


//import basic.BinarySearch;
/**
 * 数组的排序：选择排序、插入排序
 * @author admin
 *
 */
public class Sort {

	public static void main(String[] args){
		int[] nums = {1,3,54,200,34,2,38,45,2,22,43,4,78,6};//1 2 3 4 6 22 34 38 43 45 54 78 200 
		
		//bubbleSort(nums);
		//insertSort(nums);
		//simpleSelectSort(nums);
		//quickSort(nums, 0, nums.length - 1);
		insertSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	/**
	 * 时间复杂度：O(n*n)
	 * 简单选择排序法：每次从剩余元素中选择一个最小值，交换最小值与数组中相应位置上的数值
	 * n趟
	 * @param nums
	 */
	public static void simpleSelectSort(int[] nums){
		
		for(int i = 0;i < nums.length;i++){ //趟数
			int k = i; //暂存当前位置
			int min = nums[i]; //暂存当前元素
			//查找剩余元素中的最小值
			for(int j = i + 1; j < nums.length;j++){
				if(nums[j] < min){
					min = nums[j];
				    k = j;
				}
			}
			
			//交换元素，根据元素下标来交换元素
			if(i != k){
				nums[k] = nums[i];
				nums[i] = min;
			}	
		}
	}
	
	/**
	 * 时间复杂度：O(n*n)
	 * 直接插入排序法：依次从剩余元素中取得一个，插入到前面有序子序列中
	 * n-1趟
	 * @param nums
	 */
	public static void insertSort(int[] nums){
		if(nums == null) return;
		int len = nums.length;
		int tmp;
		int j; //插入位置
		for(int i = 1 ;i < len; i++){ // n-1趟
			tmp = nums[i];//暂存
			for(j = 0; j < i && nums[i] >= nums[j] ; j++); //nums[i] > nums[j]时结束，查找插入位置，j为插入位置
			for(int k = i;k >= j + 1;k--) //移位
				nums[k] = nums[k - 1];
			nums[j] = tmp; //插入值
		}
	}
	
	/**
	 * 冒泡排序 时间复杂度
	 * 时间复杂度： O(n*n)
	 * n-1趟
	 * @param nums
	 */
	public static void bubbleSort(int[] nums){
		if(nums == null)  return;
		boolean flag = false; //一趟完成有没有进行交换
		int tmp,len = nums.length;
		for(int i = 0; i < len - 1; i++) { //趟数
			for(int j = 0; j < len - 1 - i; j++){//每一趟要比较的元素个数
				if(nums[j] > nums[j + 1]){ //交换元素
					flag = true;
					tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
			if(!flag) //若一趟冒泡之后，没有进行元素交换，结束
				break;
		}
	}
	
	/**
	 * 数组翻转
	 * 时间复杂度：O(n)
	 * @param nums
	 */
	public static void reverse(int[] nums){
		
		if(nums == null) return;
		int tmp;
		int len = nums.length;
		// 翻转数组元素
		for (int i = 0,k = len - 1; i <= k; i++,k--) {
			tmp = nums[i];
			nums[i] = nums[k];
			nums[k] = tmp;
		}
	}
	
	/**
	 * 快速排序：递归运算
	 * 定义枢轴，枢轴处的元素将数组分为两部分，比其大的放在右边，不大于它的放在左边，
	 * 这样，作为枢轴的元素就调整到了排序后的正确位置。
	 * 分别对左、右两部分子序列进行递归快速排序。直到所有元素都调整到排序后的位置为止。
	 * 方法：two pointers，两个指针，分别从左、右进行遍历
	 * 时间复杂度：O(nlogn)，平均时间复杂度性能最好
	 * @param nums
	 */
	public static void quickSort(int[] nums,int left,int right){//left：下界，right：上界
		
		if(left < right){
			int pivot = nums[left]; //枢轴
			int low = left;
			int high = right;
			while(low < high){ //一轮快速排序，将其分为左、右两部分
				while(low < high && nums[high] > pivot) //从右向左寻找第一个不大于pivot的元素
					high--;
				nums[low] = nums[high]; //移动元素
				while(low < high && nums[low] <= pivot) //从左向右寻找第一个比pivot大的元素
					low++;
				nums[high] = nums[low]; //移动元素
			}
			
			nums[low] = pivot;//枢轴元素放到排序后的最终位置上
			//分别对左、右两部分进行快排
			quickSort(nums, left, low - 1);
			quickSort(nums, low + 1, right);
		}
	}
}