/**
 * 
 */
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of integers and bucket capacity k(sum of the elements in the bucket should not exceed k), return minimum buckets required to hold all the elements in the array. You are required to return list of buckets not number of buckets.

Example.
Arr = [7,3,5,4,1] and bucket size is 9.
return --> [ [7,1],[5,4],[3]]. if multiple answer is possible with same number of buckets then return any of them.

Followup Question ---> in case of multiple answer return buckets such that maximum difference between sum of elements in the buckets should be minimum.

so for above example return [ [7],[5,1],[4,3] ],
1st bucket sum = 7
2nd bucket sum = 6
3rd bucket sum = 7

maximum difference between bucket =1 (which is minimum).*/

public class Bucket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		listBuckets(new int[] { 7, 3, 5, 4, 1, 8 , 1}, 9);
	}

	public static void listBuckets(int[] in, int bucketsize) {
		Arrays.sort(in);
		List<List<Integer>> finalL = new ArrayList<List<Integer>>();
		int sum = 0;
		int i = 0, j = in.length - 1;
		List<Integer> inL = new ArrayList<Integer>();
		while (i < j) {
			while (sum + in[j] <= bucketsize) {
				inL.add(in[j]);
				sum += in[j--];
			}
			
			while(sum+in[i] <= bucketsize) {
				inL.add(in[i]);
				sum += in[i++];
			}
			
			finalL.add(inL);
			inL = new ArrayList<>();
			sum = 0;
		}
		
		if(i == j && in[i] < bucketsize) {
			inL.add(in[i]);
			finalL.add(inL);
		}

		for (List<Integer> l : finalL) {
			for (int p : l) {
				System.out.print(p + " ");
			}
			System.out.println();
		}
	}
}
