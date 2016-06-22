package interview.datastructure;

import interview.algorithms.BinaryTree;
import interview.algorithms.TreeNode;

/**
 * 判断一颗二叉树是否是平衡二叉树
 * @author WeiCuicui
 *
 */
public class IsBBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		// 向下取整(logn) + 1，完全二叉树的高度，结点个数为n
		System.out.println(Math.floor(Math.log(n)) + 1); 
		
		Object[] array = {1,2,5,null,6,7,null};
		TreeNode root = BinaryTree.createBinaryTree_NoComplete(array);
		System.out.println(isBalancedBT(root));
		
	}
	
	//判读一颗树是否为平衡二叉树
	public static boolean isBalancedBT(TreeNode root){
		if(root == null) //根结点为空，平衡
			return true;
		int left = DepthOfBT.depthOfBT(root.left);
		int right = DepthOfBT.depthOfBT(root.right);
		if(Math.abs(left - right) > 1) //左右子树的高度差大于1，不平衡
			return false;
		//若根结点的左右子树的高度差  <= 1，则根结点平衡，还需递归判断其左右子树是否平衡
		return isBalancedBT(root.left) && isBalancedBT(root.right);
		
	}
}
