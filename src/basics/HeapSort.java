package basics;

/**
 * 堆排序
 * 不稳定，辅助空间为O(1)， 最坏时间复杂度为O(nlog2n)
 * @author Administrator
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        print(data5);  
        heapSort(data5);  
        System.out.println("排序后的数组：");  
        print(data5);
	}
	
	/**
	 * 交换元素
	 * @param data
	 * @param i
	 * @param j
	 */
	public static void swap(int[] data, int i, int j) {  
        if (i == j) {  
            return;  
        }  
        int tmp = data[j];
        data[j] = data[i];
        data[i] = tmp;
    }  
  
	/**
	 * 堆排序，每次输出一个元素，都需要重新调整堆
	 * @param data
	 */
    public static void heapSort(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            //createMaxHeap(data, data.length - 1 - i);  
        	createMinHeap(data, data.length - 1 - i); //调整堆
            swap(data, 0, data.length - 1 - i); // 输出最大值
            print(data);  
        }  
    }  
  
    /**
     * 创建最大堆
     * @param data
     * @param lastIndex
     */
    public static void createMaxHeap(int[] data, int lastIndex) {  
    	// (lastIndex - 1) / 2 求得的是最后一个非叶结点的下标
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {  
            // 保存当前正在判断的节点  
            int k = i;  
            // 若当前节点的子节点存在  
            while (2 * k + 1 <= lastIndex) {  
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点  
                int biggerIndex = 2 * k + 1;  
                if (biggerIndex < lastIndex) { // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex  
                    if (data[biggerIndex] < data[biggerIndex + 1]) {  
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值  
                        biggerIndex++;  
                    }  
                }  
                if (data[k] < data[biggerIndex]) {  
                    // 若当前节点值比子节点最大值小，则交换2者的值，交换后将biggerIndex值赋值给k  
                    swap(data, k, biggerIndex);  
                    k = biggerIndex;  //下一步需要调整以该结点为根的子树
                } else {  
                    break;  
                }  
            }  
        }  
    }  
  
    /**
     * 输出数据
     * @param data
     */
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + " ");  
        }  
        System.out.println();  
    }
    
    /**
     * 创建最小堆
     * @param data
     * @param lastIndex
     */
    public static void createMinHeap(int[] data, int lastIndex) {  
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {  
            // 保存当前正在判断的节点  
            int k = i;  
            // 若当前节点的子节点存在  
            while (2 * k + 1 <= lastIndex) {  
                // smallerIndex总是记录较小节点的值,先赋值为当前判断节点的左子节点  
                int smallerIndex = 2 * k + 1;  
                if (smallerIndex < lastIndex) {  
                    // 若右子节点存在，否则此时smallerIndex应该等于 lastIndex  
                    if (data[smallerIndex] > data[smallerIndex + 1]) {  
                        // 若右子节点值比左子节点值小，则smallerIndex记录的是右子节点的值  
                        smallerIndex++;  
                    }  
                }  
                if (data[k] > data[smallerIndex]) {  
                    // 若当前节点值比子节点最大值大，则交换2者的值，交换后将smallerIndex值赋值给k  
                    swap(data, k, smallerIndex);  
                    k = smallerIndex;  
                } else {  
                    break;  
                }  
            }  
        }  
    }
}
