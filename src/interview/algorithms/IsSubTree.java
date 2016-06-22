package interview.algorithms;

/**
 * 判断一棵树是否为另一棵树的子树
 * （结点值允许重复）
 * @author WeiCuicui
 *
 */
public class IsSubTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] tree1 = {4,2,3,4,5,6,7,8,9};
		Object[] tree2 = {4,8,9};
		TreeNode root1 = BinaryTree.createBinaryTree(tree1);
		TreeNode root2 = BinaryTree.createBinaryTree(tree2);
		System.out.println(isPartTree(root1,root2));
	}
	
	public static boolean isPart(TreeNode root1, TreeNode root2){
	    if (root2 == null)
	        return true;
	    if (root1 == null)
	        return false;
	    if (root1.val != root2.val)
	        return false;
	    return isPart(root1.left, root2.left) &&
	        isPart(root1.right, root2.right);
	}
	
	public static boolean isPartTree(TreeNode root1, TreeNode root2){
	    boolean result = false;
	    if (root1 != null && root2 != null){
	        if (root1.val == root2.val) //第一种情况，有对应的结点值相同
	            result = isPart(root1, root2);
	        if (!result)
	            result = isPartTree(root1.left, root2); //根结点值不等，在左子树中查找
	        if (!result)
	            result = isPartTree(root1.right, root2); //根结点值不等，左子树中不存在，在右子树中查找
	    }
	    return result;
	}

}
