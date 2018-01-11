package general;

import java.util.HashMap;
import java.util.Map;

public class MatchingPairs {

	public static void main(String[] args) {
		System.out.println(getMatchingLastIndex("ABbCCa"));
	}

	public static int getMatchingLastIndex(String in) {
		int i = 0;
		if (!Character.isUpperCase(in.charAt(0))) {
			return i;
		}

		Map<Character, Integer> matchMap = new HashMap<Character, Integer>();

		for (i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);
			char upperCh = Character.toUpperCase(ch);
			if (Character.isUpperCase(in.charAt(i))) {
				if (!matchMap.containsKey(ch)) {
					matchMap.put(ch, 1);
				} else {
					matchMap.put(ch, matchMap.get(ch) + 1);
				}
			} else {
				if (!matchMap.containsKey(upperCh)) {
					break;
				}

				if (matchMap.containsKey(upperCh) && matchMap.get(upperCh) != null) {
					if (matchMap.get(upperCh) >= 1) {
						matchMap.put(upperCh, matchMap.get(upperCh) - 1);
						if(matchMap.get(upperCh) == 0) {
							matchMap.remove(upperCh);
						}
					} else {
						break;
					}
				} else if (matchMap.containsKey(upperCh) && matchMap.get(upperCh) != 0) {
					matchMap.put(upperCh, matchMap.get(upperCh) - 1);
				} else {
					break;
				}
			}
			
			if(matchMap.isEmpty()) {
				break;
			}
		}

		return i == in.length() ? i - 1 : i;
	}

}
