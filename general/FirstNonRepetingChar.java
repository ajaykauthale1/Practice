package general;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Example: GOOGLE Return: L
 */
public class FirstNonRepetingChar {

	public static void main(String[] args) {
		System.out.println(getFirstNonRepChar("GOOGLLEEDGGGF"));
	}

	public static Character getFirstNonRepChar(String args) {
		Character ch = null;
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character c : args.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Character c : map.keySet()) {
			if (map.get(c) == 1) {
				ch = c;
				break;
			}
		}
		return ch;
	}

	// more optimize but O(n2) because of indexof
	public int firstUniqChar(String g) {
		for (int i = 0; i < g.length(); i++) {
			char c = g.charAt(i);
			if (g.indexOf(c) == g.lastIndexOf(c)) {
				return g.indexOf(c);
			}
		}
		return -1;
	}
}
