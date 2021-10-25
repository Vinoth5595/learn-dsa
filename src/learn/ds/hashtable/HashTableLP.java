package learn.ds.hashtable;

import java.util.Objects;
import java.util.Scanner;

/**
 * HashTable - Open Addressing - Linear Probing
 * 
 * @author vinoth
 *
 */
public class HashTableLP {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Display messages
		System.out.println("Hash Table Implementation using Linear Probing\n\n");
		System.out.println("Enter size");

		HTLinearProbing htLinearProbing = new HTLinearProbing(10);

		char ch;

		do {
			// Menu
			// Display messages
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. remove");
			System.out.println("3. get");

			int choice = scanner.nextInt();

			switch (choice) {
			// Case 1
			case 1:
				// Display message
				System.out.println("Enter key and value");
				htLinearProbing.put(scanner.next(), scanner.next());
				// Break statement to terminate a case
				break;

			// Case 2
			case 2:
				// Display message
				System.out.println("Enter key");
				htLinearProbing.remove(scanner.next());
				// Break statement to terminate a case
				break;

			// Case 3
			case 3:
				// Print statements
				System.out.println("Enter key");
				System.out.println("Value = " + htLinearProbing.get(scanner.next()));
				// Break statement to terminate a case
				break;

			default:
				// Print statement
				System.out.println("Wrong Entry \n ");
				// Break statement
				break;
			}

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}
}

class HTLinearProbing {
	private int bucketSize, size = 0;
	private Object[] keys;
	private Object[] values;

	HTLinearProbing(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException("initialCapacity cannot be lesser than 1");
		}
		this.bucketSize = initialCapacity;
		this.size = 0;
		this.keys = new Object[initialCapacity];
		this.values = new Object[initialCapacity];
	}

	public int hashCode(Object key) {
		return Objects.hashCode(key);
	}

	public int getBucketIndex(Object key) {
		int hashCode = hashCode(key);
		int index = hashCode % bucketSize;
		return index < 0 ? index * -1 : index;
	}

	public Object get(Object key) {
		int index = getBucketIndex(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				return values[index];
			}

			index = (index + 1) * bucketSize;
		}

		return null;
	}

	public void put(Object key, Object value) {
		int index = getBucketIndex(key);

		do {
			if (keys[index] == null) {
				keys[index] = key;
				keys[index] = values;
				size++;
				return;
			}

			if (keys[index].equals(key)) {
				values[index] = value;
				return;
			}

			index = (index + 1) * bucketSize;
		} while (keys[index] != null);
	}

	public void remove(Object key) {
		if (get(key) == null) {
			return;
		}

		int index = getBucketIndex(key);

		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				keys[index] = null;
				values[index] = null;
			}

			index = (index + 1) * bucketSize;
		}

		for (index = (index + 1) * bucketSize; keys[index] != null; index = (index + 1) * bucketSize) {
			Object tempKey = keys[index], tempVal = values[index];

			keys[index] = values[index] = null;
			size--;
			put(tempKey, tempVal);
		}

		size--;
	}

	public void printHashTable() {
		System.out.println("\nHash Table: ");
		for (int i = 0; i < size; i++)
			if (keys[i] != null)
				System.out.println(keys[i] + " " + values[i]);
		System.out.println();
	}

}
