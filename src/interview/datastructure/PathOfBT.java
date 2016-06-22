package interview.datastructure;

import java.util.Stack;
import interview.algorithms.BinaryTree;
import interview.algorithms.TreeNode;

/**
 * 二叉树的路径
 * 给定一个sum值
 * 判断有几条路径上的值之和为sum，输出这些路径
 * @author WeiCuicui
 *
 */
public class PathOfBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] array = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = BinaryTree.createBinaryTree(array);
		int sum = 11;
		Stack<Integer> stack = new Stack<Integer>();
		findPath(root, sum, stack, 0);
	}
	
	/**
	 * 查询结点之和为sum的路径
	 * 递归
	 * @param root
	 * @param expectSum
	 * @param stack
	 * @param currentSum
	 */
	public static void findPath(TreeNode root, int expectSum, Stack<Integer> stack, int currentSum) {  
		if(root == null)
			return;
		//入栈，并增加当前的统计和
		stack.push(Integer.parseInt(root.val.toString()));
		currentSum += Integer.parseInt(root.val.toString());
		
		//如果是叶子结点，则输出路径，stack中存储的是一条路径上所有结点
		boolean isLeaf = root.left == null && root.right == null;
		if(isLeaf && currentSum == expectSum){
		    for(int i = 0; i < stack.size(); i++)
		    	System.out.print(stack.get(i) + " ");
		    System.out.println();
		}
		
		//不是叶子结点，则遍历它的孩子结点
		//遍历左子树
		if(root.left != null)
			findPath(root.left, expectSum, stack, currentSum);
		
		//遍历右子树
		if(root.right != null)
			findPath(root.right, expectSum, stack, currentSum);
		
		//在返回父结点之前，删除路径上该结点
		stack.pop();
		
    }  
}
