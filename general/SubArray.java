package general;

/*
Given an array nums and a subsequence sub, find the shortest subarray of nums that contains sub.

Example: nums = [1,2,3,5,8,7,6,9,5,7,3,0,5,2,3,4,4,7], sub = [5,7]
Answer: start = 8, size = 2

If such subarray does not exist, return -1, -1.
Note that the subarray must contain the elements of sub in the correct order..*/

public class SubArray {

	public static void main(String[] args) {
		findSubArray(new int[]{1,2,3,5,8,7,6,9,5,7,3,0,5,2,3,4,4,7}, new int[]{1,2,4,7});
	}

	public static void findSubArray(int[] in, int[] sub) {
		int i = 0, j = 0;
		int lastMinSubSize = Integer.MAX_VALUE;
		int startpos = -1;
		while (i < in.length) {
			int cnt = 0;
			while (j < sub.length && i < in.length) {
				if (sub[j] == in[i]) {
					break;
				}
				i++;
			}
			if(i >= in.length) {
				break;
			}
			int start = i;
			cnt = 1;
			while (j < sub.length && i < in.length) {
				if (sub[j] != in[i]) {
					i++;
					cnt++;
				} else {
					j++;
				}
			}
			
			if(j == sub.length) {
				if(lastMinSubSize > cnt) {
					lastMinSubSize = cnt;
					startpos = start;
				}
			}
			
			j = 0;
			i = start+1;
		}

		if(startpos == -1) {
			lastMinSubSize = -1;
		}
		
		System.out.println(startpos + " " +lastMinSubSize);
	}

}
