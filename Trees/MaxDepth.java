/**
 * 
 */
package Trees;

/**
 * @author Ajay
 *
 */
public class MaxDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = null;
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		
		System.out.println(getMaxDepth(root));
	}
	
	public static int getMaxDepth(TreeNode node) {
		if(node == null) return 0;
		if(node.left == null && node.right == null) return 0;
		
		return 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
	}

}
