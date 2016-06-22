package interview.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import interview.algorithms.BinaryTree;
import interview.algorithms.TreeNode;

/**
 * 交换二叉树的左右子树
 * @author WeiCuicui
 *
 */
public class SwapLeftRight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] objects = {1,2,3,4,5,6,7};
		TreeNode root = BinaryTree.createBinaryTree(objects);
		swap(root);
		levelSearch(root);
	}
	
	public static void swap(TreeNode root){
		if(root == null)
			return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		swap(root.left);
		swap(root.right);
	}
	
	/**
	 * 层次遍历二叉树
	 * 按照层次输出二叉树中的结点
	 * @param root
	 */
	public static void levelSearch(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nCount = 1; //记录每一层中的结点个数
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			nCount--;
			System.out.print(node.val + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			if(nCount == 0){ //输出完一层后，重新赋值nCount为新的一层中的结点个数
				System.out.println();
				nCount = queue.size();
			}
		}
	}

}
