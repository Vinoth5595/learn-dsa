package learn.ds.hashtable;

import java.util.Objects;

class HashEntry{
	Object key;
	Object value;
	
	HashEntry(Object key, Object value){
		this.key = key;
		this.value = value;
	}
}

class HashTableDH{
	int bucketCapacity;
	int size;
	HashEntry[] table;
	int primeNumber;
	
	HashTableDH(int initialCapacity){
		bucketCapacity = initialCapacity;
		size = 0;
		table = new HashEntry[bucketCapacity];
		
		for(int i = 0; i < bucketCapacity; i++) {
			table[i] = null;
		}
		
		primeNumber = getPrimeNumber();
	}

	private int getPrimeNumber() {
		for(int i = bucketCapacity - 1;  i >= 1; i--) {
			int count = 0;
			for(int j = 2; (j * j) <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			
			if(count == 0) {
				return i;
			}
		}
		
		return 3;
	}
	
	public int hashCode(Object key) {
		return Objects.hashCode(key);
	}
	
	public int hash1(Object key) {
		int hashCode = hashCode(key);
		int index = hashCode % bucketCapacity;
		return index < 0 ? index * -1 : index;
	}
	
	public int hash2(Object key) {
		int hashCode = hashCode(key);
		int index = hashCode % bucketCapacity;
		index = index < 0 ? index * -1 : index;
		
		return primeNumber - index % primeNumber;
	}
	
	public Object get(Object key) {
		int hashCode1 = hash1(key);
		int hashCode2 = hash2(key);
		
		while(table[hashCode1] != null) {
			if(!table[hashCode1].key.equals(key)){
				hashCode1 += hashCode2;
				hashCode1 %= bucketCapacity;
			}
		}
		
		return table[hashCode1].value;
	}
	
	public void put(Object key, Object value) {
		if(size == bucketCapacity) {
			return;
		}
		
		int hash1 = hash1(key);
		int hash2 = hash2(key);
		
		while(table[hash1] != null){
			hash1 += hash2;
			hash1 %= bucketCapacity;
		}
		
		table[hash1] = new HashEntry(key, value);
		size++;
	}
	
	public void remove(Object key) {
		int hash1 = hash1(key);
		int hash2 = hash2(key);
		
		while(table[hash1] != null && !table[hash1].key.equals(key)) {
			hash1 += hash2;
			hash1 %= bucketCapacity;
		}
		
		table[hash1] = null;
		size--;
	}
	
	public void printHashTable() {
		System.out.println("HashTable");
		
		for(int i = 0; i < size; i++) {
			if(table[i] != null)
				System.out.println("index - " + i + " : Key - " + table[i].key + ", value - " + table[i].value);
		}
	}
}

public class HashTableDHMain {

	public static void main(String[] args) {
		HashTableDH hashTableDH = new HashTableDH(10);
		
		hashTableDH.put(1, "One");
		hashTableDH.put(2, "Two");
		hashTableDH.put(3, "Three");
		
		hashTableDH.printHashTable();
	}

}
