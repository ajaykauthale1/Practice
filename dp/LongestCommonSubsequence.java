package dp;

public class LongestCommonSubsequence {
	
	public static void main(String args[]) {
		System.out.println(LCS("zxabcdezy", "yzabcdezx"));
	}
	
	public static int LCS(String in1, String in2) {
		int[][] dp = new int[in1.length()+1][in2.length()+1];
		
		for(int i = 1; i <= in1.length(); i++) {
			for(int j = 1; j <= in2.length(); j++) {
				char first = in1.charAt(i-1);
				char second = in2.charAt(j-1);
				if (first == second) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[in1.length()][in2.length()];
	}
}
