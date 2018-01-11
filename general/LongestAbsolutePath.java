/**
 * 
 */
package general;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ajay
 *
 */
public class LongestAbsolutePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPath("user\n\t\notes.txt"));
	}
	
	static int longestPath(String input) {
		 Deque<Integer> stack = new ArrayDeque<>();
	        stack.push(0); // "dummy" length
	        int maxLen = 0;
	        for(String s:input.split("\n")){
	            int lev = s.lastIndexOf("\t")+1; // number of "\t"
	            while(lev+1<stack.size()) stack.pop(); // find parent
	            int len = 0;
	            if(s.contains(".")) {
	                 len = stack.peek()+s.substring(0, s.indexOf(".")).length()-lev+1; // remove "/t", add"/"
	            stack.push(len);
	            } else {
	                  len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
	            stack.push(len);
	            }
	            stack.push(len);
	            // check if it is file
	            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
	        }
	        return maxLen;
	}
}
