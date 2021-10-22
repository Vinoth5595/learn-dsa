package learn.ds.hashtable;

/**
 * Node class
 * 
 * @author vinoth
 *
 * @param <K> the key
 * @param <V>
 */
class Node<K, V>{
	int hash;
	K key;
	V value;
	Node<K, V> next;
	
	Node(int hash, K key, V value, Node<K, V> next){
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
	
	
	
}

public class CustomHashTable {

	public static void main(String[] args) {
		int a  = -1454;
		
		System.out.println(~5);
	}

}
