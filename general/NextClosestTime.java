package general;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.omg.CORBA.SystemException;

public class NextClosestTime {

	public static void main(String[] args) {
		nexClose("01:53");
		nexCloseNew("01:53");
	}

	////////////////////////////// New Solution/////////////////////////////////
	public static void nexCloseNew(String time) {
		time = time.replaceAll(":", "");
		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < time.length(); i++) {
			set.add(Integer.parseInt(time.charAt(i) + ""));
		}

		int[] digits = new int[set.size()];
		int cnt = 0;
		for (int i : set) {
			digits[cnt++] = i;
		}

		List<String> permutations = new LinkedList<String>();
		getPermutations(digits, permutations, 0, 4);

		int min = Integer.MAX_VALUE;
		String close = "";

		for (String s : permutations) {
			int diff = getDiffInMinutes(time, s);
			if (diff != 0 && min > diff) {
				min = diff;
				close = s;
			}
		}
		close = close.isEmpty() ? time : close;
		String res = close.substring(0, 2) + ":" + close.substring(2);
		System.out.println(res);

	}

	static void getPermutations(int[] digits, List<String> permutations, int current, int numOfDigits) {
		if (numOfDigits == 0) {
			String perm = "" + current;
			if (perm.length() == 4) {
				if (!isInvalidTime(Integer.parseInt(perm.substring(0, 2)), Integer.parseInt(perm.substring(2)))) {
					permutations.add(perm);
				}
			} else {
				while (perm.length() != 4) {
					perm = "0" + perm;
				}
				if (!isInvalidTime(Integer.parseInt(perm.substring(0, 2)), Integer.parseInt(perm.substring(2)))) {
					permutations.add(perm);
				}
			}
		} else {
			for (int n : digits) {
				getPermutations(digits, permutations, current * 10 + n, numOfDigits - 1);
			}
		}
	}

	///////////////////////////// Old Solution ////////////////////////////////
	public static void nexClose(String time) {
		time = time.replaceAll(":", "");
		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < time.length(); i++) {
			set.add(Integer.parseInt(time.charAt(i) + ""));
		}

		int[] digits = new int[set.size()];
		int cnt = 0;
		for (int i : set) {
			digits[cnt++] = i;
		}

		List<String> combinations = new LinkedList<String>();
		getAllCombinations(digits, combinations, 0, 4);

		int min = Integer.MAX_VALUE;
		String close = "";

		for (String newTime : combinations) {
			int diff = getDiffInMinutes(time, newTime);
			if (diff != 0 && min > diff) {
				min = diff;
				close = newTime;
			}
		}
		close = close.isEmpty() ? time : close;
		String res = close.substring(0, 2) + ":" + close.substring(2);
		System.out.println(res);
	}

	static int getDiffInMinutes(String oldTime, String newTime) {
		int diff = 0;
		int hr1 = Integer.parseInt(oldTime.substring(0, 2));
		int hr2 = Integer.parseInt(newTime.substring(0, 2));
		int mn1 = Integer.parseInt(oldTime.substring(2));
		int mn2 = Integer.parseInt(newTime.substring(2));

		int hrMins = (hr2 - hr1) * 60;
		diff = hrMins + (mn2 - mn1);

		if (hr2 < hr1 || diff < 0) {
			diff = (60 * hr2) + mn2 + ((60 * (24 - hr1)) - mn1);
		}

		/*if (diff < 0) {
			diff = (60 * hr2) + mn2 + ((60 * (24 - hr1)) - mn1);
		}
*/
		return diff;
	}

	static boolean isInvalidTime(int hr, int mn) {
		if (hr > 24 || mn > 59) {
			return true;
		}
		return false;
	}

	static void getAllCombinations(int[] digits, List<String> combinations, int current, int numDigits) {
		if (numDigits == 0) {
			if (current < 10) {
				combinations.add("000" + current);
				return;
			} else if (current < 100) {
				combinations.add("00" + current);
				return;
			}
			if (current < 1000) {
				combinations.add("0" + current);
				return;
			} else {
				combinations.add("" + current);
				return;
			}
		} else {
			for (int x : digits) {
				getAllCombinations(digits, combinations, current * 10 + x, numDigits - 1);
			}
		}
	}
}
