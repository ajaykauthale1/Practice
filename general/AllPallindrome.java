/**
 * 
 */
package general;

/**
 * @author Ajay
 *
 */
public class AllPallindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printAllPallindrome("abacddeddcaba");
	}
	
	//n2 complexity
	public static void printAllPallindrome(String input) {
		int length = input.length();
		String longestPal = "";
		
		for (int i = 0; i <= length; i++) {
			for(int j = 2; j <= length+1; j++) {
				int k = i + j - 1;
				if(k > length) {
					continue;
				}
				
				StringBuffer str = new StringBuffer();
				str.append(input.substring(i, k));
				String rev = str.reverse().toString();
				String cur = input.substring(i, k);
				if(cur.equals(rev)) {
					if(longestPal.length() < cur.length()) {
						longestPal = cur;
					}
					System.out.println(cur);
				}
			}
		}
		
		System.out.println("Longest: "+ longestPal);
	}

}
