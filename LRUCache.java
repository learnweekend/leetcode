
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 * 
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
Follow up:
Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

public class LRUCache {

	private ListNode head; // LRU items
	private ListNode tail; // MRU items
	private Map<Integer, ListNode> map; // to store items
	private int capacity; // max size of the cache
	private int size; // actual size of the cache

	public LRUCache(int capacity) {
		this.map = new HashMap<Integer, ListNode>(capacity);
		this.capacity = capacity;
		this.size = 0;
		tail = head;
	}

	/**  get(key)
	 *  1. returns -1 if key doesn't exists in cache
	 *  2. remove node from list
	 *  3. create new node.
	 *  4. append new node on tail
	 *  5. put the key,value in cache.
	 *  6. return value
	 */
	public int get(int key) {
		ListNode node = map.get(key);
		if (node == null)
			return -1; // return -1 if key doesn't exists

		removeListNode(node); // Remove node from list
		ListNode temp = new ListNode(key, node.value); // create new node
		appendListNode(temp); // append to tail
		map.put(key, temp); // put new node in the map
		return node.value;
	}
	
	/**
	 * put(key, value)
	 * 1. if present in cache
	 * 			2. get(key)
	 * 			3. override the value and return;
	 * 4. create new node
	 * 5. check the capacity
	 * 6. remove head key from map
	 * 7. remove head from List
	 * 8. put(key, value) into the map
	 * 9. append new node in the List(tail)
	 * 10. increment size
	 */
	public void put(int key, int value) {
		if (map.containsKey(key)) {  // check if key is present in cache
			get(key);
			map.get(key).value = value;  // override the value
			return;
		}
		ListNode temp = new ListNode(key, value);
		if (size == capacity) {
			map.remove(head.key); // 1. Remove from map, NOTE : head.key
			removeListNode(head); // 2. Remove head - since head refers to LRU
			size--;
		}
		map.put(key, temp);   // insert new node in map
		appendListNode(temp); // append new node to tail
		size++; // increment the size
	}

	/** Removes the given node from list */
	
	private void removeListNode(ListNode node) {
		if (node == head) {
			head = head.next;
			if (head != null)
				head.prev = null;
		}
		if (node == tail) {
			tail = tail.prev;
		}
		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
	}

	/**
	 *  Appends the node on tail
	 */
	private void appendListNode(ListNode node) {
		if (tail == null) {
			tail = node;
			head = tail;
			return;
		}
		tail.next = node;
		tail.next.prev = tail;
		tail = tail.next;
	}

	/**
	 * Doubly linked ListNode - stores key and value
	 */
	private static class ListNode {
		private int key;
		private int value;
		private ListNode prev;
		private ListNode next;

		public ListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 );
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    							// evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    							// evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}