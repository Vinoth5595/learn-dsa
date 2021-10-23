package learn.ds.hashtable;

import java.util.ArrayList;
import java.util.Objects;

class HashNode<K, V>{
	K key;
	V value;
	final int hashCode;
	HashNode<K, V> next;
	
	HashNode(K key, V value, final int hashCode){
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}
	
	@Override
	public String toString() {
		return key + "=" + value;
	}
}

class HashMap<K, V>{
	private ArrayList<HashNode<K, V>> bucketArray;
	
	int bucketCapacity;
	
	int size;
	
	HashMap(){
		bucketArray = new ArrayList<>();
		bucketCapacity = 10;
		size = 0;
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
	
//	public V remove(K key) {
//		int bucketIndex = getBucketIndex(key);
//		int hashCode = hashCode(key);
//		
//		HashNode<K, V> head = bucketArray.get(bucketIndex);
//		
//		if(head != null) {
//			bucketArray.set(bucketIndex, null);
//			size--;
//		}
//		
//	}
	
}

public class CustomHashTable {

	public static void main(String[] args) {
	}

}
