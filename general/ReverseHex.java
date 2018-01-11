package general;

import java.util.ArrayList;
import java.util.List;

public class ReverseHex {

	public static void main(String[] args) {
		reverseHex("5d347e8987883486798a798687793479827b7d82797986797834887c7d87");
	}

	public static void reverseHex(String str) {
		int prevIndex = 0;
		List<String> lst = new ArrayList<>();
		for (int i = 0; i <= str.length(); i++) {
			if (i > 0 && i % 2 == 0) {
				lst.add(str.substring(prevIndex, i));
				prevIndex = i;
			}
		}

		for (String s : lst) {
			System.out.print(Character.toString ((char) (Integer.parseInt(s, 16)-20)));
		}
	}

}
