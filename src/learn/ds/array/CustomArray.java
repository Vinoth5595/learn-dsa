package learn.ds.array;

import java.util.Arrays;


/**
 * Custom Array
 * 
 * @author vinoth
 *
 */
class MyArray{
	private static final Object[] EMPTY_ELEMENTDATA = {};
	int length = 0;
	Object[] data;
	
	MyArray() {
		this.length = 0;
		this.data = EMPTY_ELEMENTDATA;
	}
	
	public Object get(int index) {
		return data[index];
	}
	
	public Object[] getObjectArray() {
		return this.data;
	}
	
	public int push(Object item) {
		int length = this.data.length;
		this.data = Arrays.copyOf(data, length + 1);
		this.data[length] = item;
		return length;
	}

	@Override
	public String toString() {
		return "MyArray [length=" + length + ", data=" + Arrays.toString(data) + "]";
	}
	
	
	
	public Object pop() throws Exception {
		Object oldValue = this.data[this.data.length-1];
		this.data = Arrays.copyOf(data, this.data.length-1);
		return oldValue;
	}
	
	public Object delete(int index) throws Exception {
		int newSize = this.data.length - 1;
		Object oldValue = this.data[index];
		Object[] newArray = Arrays.copyOf(this.data, newSize);
		if(index > 0) 
		 System.arraycopy(data, index + 1, newArray, index, newArray.length - 1);
		this.data = newArray;
		return oldValue;
	}
	
	public Object customDelete(int index) {
		Object[] newArray = Arrays.copyOf(this.data, this.data.length - 1);
		Object deletedValue = this.data[index]; 
		for(int i = index; i < newArray.length; i++) {
			newArray[i] = this.data[i + 1];
		}
		
		this.data = newArray;
		return deletedValue;
	}
	
	public Object valueDelete(Object valueToBeDeleted) {
		if(valueToBeDeleted == null) return null;
		
		int i = 0;
		
		for(; i < this.data.length; i++) {
			if(valueToBeDeleted.equals(this.data[i])) {
				break;
			}
		}
		
		return customDelete(i);
	}

}

public class CustomArray {

	public static void main(String[] args) throws Exception {
		MyArray myArray = new MyArray();
		myArray.push(1);
		myArray.push(2);
		myArray.push(3);
		myArray.valueDelete(3);
		System.out.println(myArray);
	}
}
