package ur;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Ajay
 *
 *         Test is modified a bit since add() and getKeys() methods are specific
 *         to MyOrderedHashMap and we cannot directly access them using map
 *         reference
 */
public class Test {

	@org.junit.Test
	public void test() {
		Map<String, Object> map = new MyOrderedHashMap<String, Object>();
		((MyOrderedHashMap<String, Object>) map).add("first", new Object());
		((MyOrderedHashMap<String, Object>) map).add("second", new Object());
		((MyOrderedHashMap<String, Object>) map).add("third", new Object());

		Iterator<String> keyIterator = ((MyOrderedHashMap<String, Object>) map).getKeys().iterator();
		assertEquals("first", keyIterator.next());
		assertEquals("second", keyIterator.next());
		assertEquals("third", keyIterator.next());
	}
	
}
