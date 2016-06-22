package interview.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//统计叶子结点的个数
public class LeafNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] tree1 = {4,2,3,4,5,6,7};
	
		TreeNode root = BinaryTree.createBinaryTree(tree1);
		
		System.out.println(numOfLeafs_levelTraversal(root));
		
		System.out.println(numOfLeafs_preOrderTraversal(root));
		
		System.out.println(numOfLeafs_inOrderTraversal(root));
		
		System.out.println(numOfLeafs_postOrderTraversal(root));
		
		System.out.println(numOfLeafs_inOrderTraversal(root)); //递归求二叉树中叶子结点的个数
		
	}

	
	/**
	 * 层序遍历
	 * @param root
	 * @return
	 */
	public static int numOfLeafs_levelTraversal(TreeNode root){
		if(root == null)
			return 0;
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode tmp = queue.poll();
			if(tmp.left != null)
				queue.add(tmp.left); //左孩子结点入队
			if(tmp.right != null)
				queue.add(tmp.right); //右孩子结点入队
			if(tmp.left == null && tmp.right == null)//叶子结点
				count++;
		}
		return count;
	}
	
	/**
	 * 非递归，先序遍历二叉树（右孩子结点先压栈，左孩子结点后压栈）
	 * @param root
	 * @return
	 */
	public static int numOfLeafs_preOrderTraversal(TreeNode root){
		if(root == null) 
			return 0;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    int count = 0;
	    stack.push(root);
	    while(!stack.isEmpty()){
	    	TreeNode tmp = stack.pop();
	    	if(tmp.left == null && tmp.right == null)
	    		count++;
	    	if(tmp.right != null)  //右孩子结点，压栈
	    		stack.push(tmp.right);
	    	if(tmp.left != null)  //左孩子结点，压栈
	    		stack.push(tmp.left);
	    }
	    return count;
	}
	
	/**
	 * 非递归，中序遍历二叉树
	 * @param root
	 * @return
	 */
	public static int numOfLeafs_inOrderTraversal(TreeNode root){
		if(root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		TreeNode p = root;
		while(!stack.isEmpty() || p != null){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if(p.left == null && p.right == null)
				count++;
			p = p.right;
		}
		return count;
	}
	
	/**
	 * 非递归，后序遍历二叉树
	 * @param root
	 * @return
	 */
	public static int numOfLeafs_postOrderTraversal(TreeNode root){
		if(root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		TreeNode p = root;
		TreeNode pre = root;//前一个已经遍历的结点
		while(p != null || !stack.isEmpty()){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			TreeNode tmp = stack.peek().right;
			if(tmp == null || tmp == pre){//右孩子为空，或者已经遍历过
				p = stack.pop();
				if(p.left == null && p.right == null)
				   count++;
				pre = p;
				p = null;
			} else {
				p = tmp;
			}
		}
		return count;
	}
	
	//递归，求二叉树中叶子结点的个数
	public static int numOfLeafs_recursion(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return numOfLeafs_inOrderTraversal(root.left) + numOfLeafs_inOrderTraversal(root.right);
	}
}
