package ur;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Ajay
 * 
 * Implementation is based on the LinkedHashMap<K, V> which has O(1) key lookup
 * 
 * @param <K> key
 * @param <V> value
 */
public class MyOrderedHashMap<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param initialCapacity
	 * @param loadFactor
	 */
	public MyOrderedHashMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * 
	 * @param initialCapacity
	 */
	public MyOrderedHashMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * 
	 */
	public MyOrderedHashMap() {
		super();
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @return Map after adding new <K, V> pair
	 */
	public Object add(K key, V value) {
		return super.put(key, value);
	}
	
	/**
	 * 
	 * @return set of keys
	 */
	public Set<K> getKeys() {
		return super.keySet();
	}
}
