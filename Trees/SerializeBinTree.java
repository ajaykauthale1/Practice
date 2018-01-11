package Trees;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/* The idea is simple: print the tree in pre-order traversal and use "X" to denote null node 
 * and split node with ",". We can use a StringBuilder for building the string on the fly. 
 * For deserializing, we use a Queue to store the pre-order traversal and since we have "X" 
 * as null node, we know exactly how to where to end building subtress
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class SerializeBinTree {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = new TreeNode(5);
		SerializeBinTree codec = new SerializeBinTree();
		codec.serialize(codec.deserialize(codec.serialize(root)));
	}

	// Encodes a tree to a single string.
	/*public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		String encode = "";
		if (root == null)
			return "";
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (node != null) {
				encode += node.val;
				queue.add(node.left);
				queue.add(node.right);
			} else {
				encode += "$";
			}
		}

		System.out.println(encode);
		return encode;
	}*/
	
	 public String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        buildString(root, sb);
	        System.out.println(sb.toString());
	        return sb.toString();
	    }

	    private void buildString(TreeNode node, StringBuilder sb) {
	        if (node == null) {
	            sb.append("$").append(",");
	        } else {
	            sb.append(node.val).append(",");
	            buildString(node.left, sb);
	            buildString(node.right,sb);
	        }
	    }

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(",")));
		return buildTree(nodes);
	}

	private static TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals("$"))
			return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
}
