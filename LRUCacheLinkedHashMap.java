
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {

	private LinkedHashMap<Integer, Integer> map;

	public LRUCacheLinkedHashMap(int capacity) {
		this.map = new LRUCache(capacity);
	}

	public int get(int key) {
		Integer val = map.get(key);
		return val == null ? -1 : val;
	}

	public void set(int key, int value) {
		map.put(key, value);
	}

	class LRUCache extends LinkedHashMap<Integer, Integer> {
		private static final long serialVersionUID = -266778255372030281L;
		private int capacity;

		LRUCache(int capacity) {
			super(capacity, 0.75f, true);  // true - for access order, and false for insertion order
			this.capacity = capacity;      
		}

		/**
		 * when size exceeds the capacity, it returns true 
		 * And removes the least recently access item 
		 */
		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
			return size() > capacity;
		}
	}
}
