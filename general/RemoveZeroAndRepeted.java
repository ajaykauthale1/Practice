package general;

/**
 * Given an array nums, which is sorted (besides 0 in between numbers), 
 * write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements and maintaining only one copy of each non-zero element.
 * For example, given nums = [0, 1, 1, 0, 3, 3, 0, 3, 4, 5, 0, 5, 5, 12], after calling your function, 
 * nums should be [1, 3, 4, 5, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0].
 * */

public class RemoveZeroAndRepeted {

	public static void main(String[] args) {
		int[] nums = removeDuplicates(new int[]{0, 1, 1, 0, 3, 3, 0, 3, 4, 5, 0, 5, 5, 12});
		for(int i = 0; i < nums.length ; i++) {
			System.out.print(nums[i]+", ");
		}
	}

	public static int[] removeDuplicates(int[] nums) {
		int prev = 0;
		int pos = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0 && nums[i] != prev) {
				nums[pos++] = nums[i];
				prev = nums[i];
			} else {
				nums[i] = 0;
			}
		}
		
		for(int i = pos; i < nums.length; i++) {
			nums[i] = 0;
		}
		
		return nums;
	}
}
