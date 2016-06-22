package interview.datastructure;

import interview.algorithms.BinaryTree;
import interview.algorithms.TreeNode;

/**
 * 求二叉树的深度
 * @author WeiCuicui
 *
 */
public class DepthOfBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] array = {1};
		TreeNode root = BinaryTree.createBinaryTree(array);
		System.out.println(depthOfBT(root));
		
	}
	
	//递归，求二叉树的深度，左、右子树深度的最大值 + 1
	public static int depthOfBT(TreeNode root){
		if(root == null)
			return 0;
		return depthOfBT(root.left) > depthOfBT(root.right) ? 
				depthOfBT(root.left) + 1 : depthOfBT(root.right) + 1;
	}

}
