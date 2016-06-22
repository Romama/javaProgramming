package interview.algorithms;

/**
 * 判断一棵树是否为另外一棵树的子结构
 * （结点值允许重复）
 * @author WeiCuicui
 *
 */
public class SubTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] tree1 = {4,2,3,4,5,6,7,8,9};
		Object[] tree2 = {4,8,9};
		TreeNode root1 = BinaryTree.createBinaryTree(tree1);
		TreeNode root2 = BinaryTree.createBinaryTree(tree2);
		System.out.println(isSubTree(root1,root2));
	}
	
	/**
	 * 判断root2是否是root1的子树
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static int isSubTree(TreeNode root1,TreeNode root2){
		int result = -1;
		if(root1 == null || root2 == null)
			return result;
		
		if(root1.val == root2.val){
			result = isSub(root1,root2); //依次比较其子结构是否相同
		} 
		if(result == -1)
			result = isSubTree(root1.left,root2); //在左子树中查找
		if(result == -1)
			result = isSubTree(root1.right,root2); //在右子树中查找
		return result;
	}
	
	/**
	 * 在根结点相同的情况下比较
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static int isSub(TreeNode root1,TreeNode root2){
		
		if(root2 == null){ //root2的结点遍历完成，都与root1相同
			return 1;
		} 
		if(root1 == null){//root1遍历完成，root2尚未完成，说明root1不包含root2
			return -1;
		}
		if(root1.val != root2.val) //root1与root2都不为空，但是两者的值不等，说明root1不包含root2
			return -1;
		
		if(isSub(root1.left,root2.left) == 1 && isSub(root1.right,root2.right) == 1){//若两者的值相等，则递归判断左右子树是否完全相同
			return 1;
		} else {
			return -1;
		}
	}

}
