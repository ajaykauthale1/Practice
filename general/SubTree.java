package general;

public class SubTree {

	
	
	 class Tree<T> {
	   Tree(T x) {
	     value = x;
	   }
	   T value;
	   Tree<T> left;
	   Tree<T> right;
	 }
	String s = "";
	boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
	    
	    if(t1 == null && t2 != null) return false;
	    if(t2 == null) return true;
	    /*preOrder(t1);
	    String s1 = s;
	    s = "";
	    System.out.println();
	    preOrder(t2);
	    System.out.println();
	    System.out.println(s1 + " " + s + " " + s1.contains(s));
	    return s1.contains(s);*/
	    
	    if(t1 == null && t2 == null) return true;
	    if(t1 == null || t2 == null) return false;
	    
	    if(t1.value == t2.value) {
	        return checkSubTree(t1, t2);
	    } else {
	        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	    }
	}

	boolean checkSubTree(Tree t1, Tree t2) {
	    /*if(t1 == null && t2 == null) return true;
	    if((t1.left == null && t2.left == null) && (t1.right == null && t2.right == null)) {
	        return true;
	    }
	    
	    if(t1.left == null || t2.left == null) return false;
	    if(t1.right == null || t2.right == null) return false;
	    
	    if((t1.left.value != t2.left.value) || (t1.right.value != t2.right.value)) {
	        return false;
	    } else {
	        return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
	    }*/
	        
	        if (t1 == null && t2 == null)
	            return true;
	  
	        if (t1 == null || t2 == null) {
	            System.out.println("unequal");
	            return false;
	        }
	            
	  
	    
	        
	        return (t1.value == t2.value
	                && checkSubTree(t1.left, t2.left)
	                && checkSubTree(t1.right, t2.right));
	}

	void preOrder(Tree<Integer> t1) {
	    if(t1 == null) {
	        s += "$";
	        return;
	    }
	    s += t1.value;
	    preOrder(t1.left);
	    preOrder(t1.right);
	}

}
