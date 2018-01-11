package Trees;

import java.util.HashMap;
import java.util.Map;

class Tree {
	char val;
	Tree left;
	Tree right;

	Tree(char x) {
		val = x;
	}
}

public class UnionTree {
	public static void main(String[] args) {
		Tree root = new Tree('A');
		root.left = new Tree('B');
		root.right = new Tree('C');
		root.left.left = new Tree('D');
		root.left.right = null;
		
		Tree root1 = new Tree('B');
		root1.left = new Tree('D');
		root1.right = new Tree('E');
		root1.left.left = new Tree('C');
		root1.left.right = new Tree('F');
		root1.right.left = null;
		root1.right.right = new Tree('G');
		union(root, root1);
	}

	public static Tree union(Tree root1, Tree root2) {
		Tree r1 = root1;
		Tree r2 = root2;
		Map<Character, Character> root1Nodes = getNodes(new HashMap<Character, Character>(), root1);
		Tree result = null;
		
		if(root1Nodes.containsKey(r2.val)) {
			result = r1;
			result = performUnion(result, r1, r2);
		} else {
			result = r2;
			result = performUnion(result, r2, r1);
		}
		
		printTree(result);
		
		return result;
	}
	
	public static void printTree(Tree t) {
		if(t == null) return;
		System.out.println(t.val);
		printTree(t.left);
		printTree(t.right);
	}
	
	public static Tree performUnion(Tree result, Tree root1, Tree root2) {
		if(root1 == null) return result;
		if(root2 == null) return result;
		if(root1.val == root2.val) {
			result = root2;
			result.left = performUnion(result, root1.left, root2);
			result.right = performUnion(result, root1.right, root2);
		} else {
			performUnion(result, root1.left, root2);
			performUnion(result, root1.right, root2);
		}
		
		return result;
	}
	
	public static Map<Character, Character> getNodes(Map<Character, Character> nodes, Tree root) {
		if (root == null) {
			return null;
		} else {
			nodes.put(root.val, root.val);
			getNodes(nodes, root.left);
			getNodes(nodes, root.right);
		}
		
		return nodes;
	}
}
