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
	HashNode[] hashNode;
	int primeNumber;
	
	HashTableDH(int initialCapacity){
		bucketCapacity = initialCapacity;
		size = 0;
		hashNode = new HashNode[bucketCapacity];
		
		for(int i = 0; i < bucketCapacity; i++) {
			hashNode[i] = null;
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
		
		while(hashNode[hashCode1] != null) {
			if(!hashNode[hashCode1].key.equals(key)){
				hashCode1 += hashCode2;
				hashCode1 %= bucketCapacity;
			}
		}
		
		return hashNode[hashCode1].value;
	}
}

public class HashTableDHMain {

	public static void main(String[] args) {
		
	}

}
