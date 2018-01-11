package ur;

import static org.junit.Assert.assertEquals;

/**
 * Class to reverse a string
 * 
 * @author Ajay
 *
 */
public class ReverseString {

	/**
	 * Method to reverse a string
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String reverse = "";

		// remove character one by one from last to first and append it to
		// result
		for (int i = string.length() - 1; i >= 0; i--) {
			reverse += string.charAt(i);
		}

		return reverse;
	}

	@org.junit.Test
	public void reverse_any_string() {
		assertEquals("gnirts elpmis", reverse("simple string"));
		assertEquals("!avaj evol I", reverse("I love java!"));
		assertEquals("eulav", reverse("value"));
	}
}
