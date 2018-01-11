/**
 * 
 */
package general;

/**
 * @author Ajay
 *
 */
public class Roses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getEarliestDay(new int[] { 2, 5, 1, 4, 3 }, 1));
		//System.out.println(getEarliestDayNew(new int[] { 2, 5, 1, 4, 3 }, 2));
	}
	
	public static int kEmptySlotsNew(int[] flowers, int k) {
        int n = flowers.length;
        if (n == 0 || k >= n) return -1;
        int[] f = new int[n + 1];
        
        for (int i = 0; i < n; ++i)
            if (IsValid(flowers[i], k, n, f))
                return i + 1;
        
        return -1;
    }
    
    private static boolean IsValid(int x, int k, int n, int[] f) {
        f[x] = 1;
        if (x + k + 1 <= n && f[x + k + 1] == 1) {
            boolean valid = true; 
            for (int i = 1; i <= k; ++i)
                if (f[x + i] == 1) {
                    valid = false;
                    break;
                }
            if (valid) return true;
        }
        if (x - k - 1 > 0 && f[x - k - 1] == 1) {
            for (int i = 1; i <= k; ++i)
                if (f[x - i] == 1) return false;
            return true;
        }
        return false;
    }

	public static int kEmptySlots(int[] flowers, int k) {
		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			days[flowers[i] - 1] = i + 1;
		}

		for (int i : days) {
			System.out.print(i + " ");
		}

		System.out.println();

		int left = 0, right = k + 1, res = Integer.MAX_VALUE;

		for (int i = 0; right < days.length; i++) {
			if (days[i] < days[left] || days[i] <= days[right]) {
				System.out.println(days[i] + " " + days[right] + " " + days[left]);
				/*if (i == right)
					res = Math.min(res, Math.max(days[left], days[right])); */
				left = i;
				right = k + 1 + i;
			}
		}

		return (res == Integer.MAX_VALUE) ? -1 : res;
	}

	public static int getEarliestDay(int[] roses, int k) {
		int[] wt = new int[roses.length];

		for (int i = 1; i <= roses.length; i++) {
			wt[roses[i - 1] - 1]++;
			if (checkIfGotK(wt, k)) {
				return i;
			}
		}

		return 0;
	}

	public static boolean checkIfGotK(int[] wt, int k) {
		//Set<Integer> s = new HashSet<Integer>();
		int cnt = 0, i = 0;
		for (i = 0; i < wt.length; i++) {
			if (wt[i] == 1) {
				if(cnt == k) {
					return true;
				}
				cnt = 0;
			} else {
				cnt++;
			}
		}

		if (cnt == k) {
			return true;
		}

		return false;
	}
	
	public static int getEarliestDayNew(int[] roses, int k) {
		int[] wt = new int[roses.length];
		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= roses.length; i++) {
			if(max < roses[i - 1] - 1) {
				max = roses[i - 1] - 1;
			}
			wt[roses[i - 1] - 1]++;
			if (checkIfGotKNew(wt, k, max)) {
				return i;
			}
		}

		return 0;
	}
	
	public static boolean checkIfGotKNew(int[] wt, int k, int max) {
		int left = 0, right = max;
		if(wt.length - max - 1 == k) {
			return true;
		}
		
		int k1 = 0, k2=0;
		while(left < right) {
			if(wt[right] == 1) {
				if(k1 == k) {
					return true;
				}
				k1 = 0;
			} else {
				k1++;
			}
			if(wt[left] == 1) {
				if(k2 == k) {
					return true;
				}
				k2 = 0;
			} else {
				k2++;
			}
			left++;
			right--;
		}
		
		if(k1 != 0 && k2 != 0) {
			if(k1+k2 == k) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int getEarliestKEmptyGroup(int[] flowers, int k) {
        int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i; 
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE)?0:res;
    }
}
