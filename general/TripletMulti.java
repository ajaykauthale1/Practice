package general;

import java.util.Arrays;

/**
 * Given an array of distinct integers(considering only positive numbers) and a
 * number ‘m’, find the number of triplets with product equal to ‘m’.
 */
public class TripletMulti {

	public static void main(String[] args) {
		tripletNaive(new int[]{ 1, 4, 6, 2, 3, 8}, 24);
		System.out.println("--------");
		tripletSofis(new int[]{ 1, 4, 6, 2, 3, 8}, 24);
	}

	// n3
	public static void tripletNaive(int[] in, int mult) {
		for (int i = 0; i < in.length-2; i++) {
			for (int j = i+1; j < in.length-1; j++) {
				for (int k = j+1; k < in.length; k++) {
					if (in[i] * in[j] * in[k] == mult) {
						System.out.println(in[i] + ", " + in[j] + ", " + in[k]);
					}
				}
			}
		}
	}
	
	// n2
	public static void tripletSofis(int[] in, int mult) {
		Arrays.sort(in);
		for(int i = 0; i < in.length-2; i++) {
			int first = in[i];
			int j = i+1;
			int k = in.length-1;
			while(j < k) {
				if(first * in[j] * in[k] == mult) {
					System.out.println(in[i] + ", " + in[j] + ", " + in[k]);
					k--;j++;
				} 
				if(first * in[j] * in[k] > mult) {
					k--;
				}
				if(first * in[j] * in[k] < mult) {
					j++;
				}
			}
		}
	}
}
