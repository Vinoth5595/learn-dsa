package learn.ds.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class HashNode<K, V> {
	K key;
	V value;
	final int hashCode;
	HashNode<K, V> next;

	HashNode(K key, V value, final int hashCode) {
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}

	@Override
	public String toString() {
		return key + "=" + value;
	}
}

class HashMap<K, V> {
	private ArrayList<HashNode<K, V>> bucketArray;

	int bucketCapacity;

	int size;

	HashMap() {
		bucketArray = new ArrayList<>();
		bucketCapacity = 10;
		size = 0;
		
		for(int i = 0; i < bucketCapacity; i++) {
			bucketArray.add(null);
		}
	}

	public int size() {
		return size;
	}

	public int hashCode(K key) {
		return Objects.hash(key);
	}

	public int getBucketIndex(K key) {
		int hashCode = hashCode(key);
		int bucketIndex = hashCode % bucketCapacity;
		return bucketIndex < 0 ? bucketIndex * -1 : bucketIndex;
	}

	public V remove(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);

		HashNode<K, V> head = bucketArray.get(bucketIndex);

		HashNode<K, V> prev = null;

		while (head != null) {
			if (head.hashCode == hashCode && head.key.equals(key))
				break;

			prev = head;
			head = head.next;
		}

		if (head == null) {
			return null;
		}

		size--;

		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArray.set(bucketIndex, head.next);
		}

		return head.value;
	}
	
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		HashNode<K, V> prev = null;
		
		while(head != null) {
			if(head.hashCode == hashCode && head.key.equals(key)) {
				return head.value;
			}
		}
		
		return null;
	}
	
	public void add(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);

		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		while(head != null) {
			if(head.hashCode == hashCode && head.key.equals(key)) {
				head.value = value;
				return;
			}
			
			head = head.next;
		}
		
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode(key, value, hashCode);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
		
		if((1.0 * size) / bucketCapacity >= 0.7) {
			List<HashNode<K, V>> temp = bucketArray;
			
			bucketCapacity = 2 * bucketCapacity;
			bucketArray = new ArrayList<>(bucketCapacity);
			
			size = 0;
			
			for(int i = 0; i < bucketCapacity; i++) {
				bucketArray.add(null);
			}
			
			for (HashNode<K, V> headNode: temp) {
				while(headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

}

public class CustomHashTable {

	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		hashMap.add("My", 123);
		hashMap.add("Test", 456);
		hashMap.add("My", 789);
		hashMap.add("One", 1);
		hashMap.add("Two", 2);
		hashMap.add("Three", 3);
		hashMap.add("Four", 4);
		hashMap.add("Five", 5);
		hashMap.add("Six", 6);
		hashMap.add("Seven", 7);
		hashMap.add("Eight", 8);
		hashMap.add("Nine", 9);
		hashMap.add("Ten", 10);
		System.out.println(hashMap.size);

		hashMap.remove("Test");
		
		System.out.println(hashMap.size + " : " + hashMap.get("My"));
	}

}
