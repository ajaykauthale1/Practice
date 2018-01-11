/**
 * 
 */
package Trees;

/**
 * @author Ajay
 *
 */
// Check whether a binary tree is contained in another binary tree. child tree structure should be considered
public class TreeContains {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = new TreeNode(5);
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(5);
		root1.left.left = null;
		root1.left.right = new TreeNode(3);
		
		System.out.println(isContained(root, root1));

	}
	
	public static boolean isContained(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return false;
		String s1 = buildString(t1, new StringBuffer());
		String s2 = buildString(t2, new StringBuffer());
		
		if(s1.length() > s2.length()) {
			return s1.indexOf(s2) > -1;
		} else {
			return s2.indexOf(s1) > -1;
		}
	}
	
	public static String buildString(TreeNode t, StringBuffer res) {
		if(t == null) {
			return "";
		} else {
			res.append(t.val);
			buildString(t.left, res);
			buildString(t.right, res);
		}
		
		return res.toString();
	}

}
