package general;

public class FarthestCoprime {

	public static void main(String[] args) {
		int[] result = farthestCoprimes(250);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] farthestCoprimes(int end) {
		int[] out = new int[end - 1];
		int k = 0;
		for (int i = 2; i <= end; i++) {
			// get coprime for each number
			out[k] = getFarthestCoprime(i, end);
			k++;
		}

		return out;
	}

	public static int getFarthestCoprime(int pivot, int end) {
		int mid = end / 2;
		int rightCoprime = 0, leftCoprime = 0;
		// if pivot is greater than mid then check coprime in left half, else
		// check coprime in right half
		// find it in right half
		if (pivot > mid) {
			for (int i = 2; i < end; i++) {
				if (isCoprime(pivot, i)) {
					leftCoprime = i;
					break;
				}
			}
		} else {
			for (int i = end; i >= 2; i--) {
				if (isCoprime(pivot, i)) {
					rightCoprime = i;
					break;
				}
			}
		}

		if (leftCoprime > rightCoprime) {
			return leftCoprime;
		} else {
			return rightCoprime;
		}
	}

	public static boolean isCoprime(int i, int j) {
		while (i != 0 && j != 0) {
			if (i > j)
				i %= j;
			else
				j %= i;
		}
		return Math.max(i, j) == 1;
	}
}
