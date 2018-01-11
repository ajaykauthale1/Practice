package general;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array A[] of integers(positive and nonpositive), how can you find a
 * continuous subarray of A[] whose sum is closest to 0? Or closest to a certain
 * value t?
 */
public class SumClosestToZero {

	public static void main(String[] args) {

	}

	public static int[] getSubArray(int[] in) {
		Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<Integer, LinkedList<Integer>>();

		for (int i = 0; i < in.length; i++) {
			for (int j = 2; j <= in.length; j++) {
				int k = i + j - 1;
				if (k > in.length) {
					continue;
				}
				int sum = 0;
				LinkedList<Integer> arr = new LinkedList<Integer>();
				for (int e = i; e <= k; e++) {
					arr.add(e);
					sum += e;
				}
				map.put(sum, arr);
			}
		}

		int[] out = new int[list.size()];
		int k = 0;
		for (int i : list) {
			out[k++] = i;
		}

		return out;
	}
}
