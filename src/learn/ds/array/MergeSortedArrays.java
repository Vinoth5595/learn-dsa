package learn.ds.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] sortedArray1 = { 1, 5, 7, 9 };
		int[] sortedArray2 = { 2, 6, 10 };

		mergeSortedArray(sortedArray1, sortedArray2);
		System.out.println(Arrays.toString(mergeSortedMapArray(sortedArray1, sortedArray2)));
	}

	private static int[] customMergeSortedArray(int[] sortedArray1, int[] sortedArray2) {
		if (sortedArray1.length <= 0) {
			return sortedArray2;
		}

		if (sortedArray2.length <= 0) {
			return sortedArray2;
		}

		int[] mergedArray = new int[sortedArray1.length + sortedArray2.length];
		int array1Item = sortedArray1[0];
		int array2Item = sortedArray2[0];
		int i = 1;
		int j = 1;
		int index = 0;

		while (i < sortedArray1.length && j < sortedArray2.length) {
			if (array1Item < array2Item) {
				mergedArray[index++] = array1Item;
				array1Item = sortedArray1[i++];
			} else {
				mergedArray[index++] = array2Item;
				array2Item = sortedArray2[j++];
			}
		}

		while (i < sortedArray1.length) {
			mergedArray[index++] = array1Item;
			array1Item = sortedArray1[i++];
		}

		while (j < sortedArray2.length) {
			mergedArray[index++] = array2Item;
			array2Item = sortedArray2[j++];
		}

		return mergedArray;
	}

	private static int[] mergeSortedMapArray(int[] sortedArray1, int[] sortedArray2) {
		if (sortedArray1.length <= 0) {
			return sortedArray2;
		}

		if (sortedArray2.length <= 0) {
			return sortedArray2;
		}
		
		Map<Integer, Boolean> treeMap = new TreeMap<>();
		for (int i : sortedArray1) {
			treeMap.put(i, true);
		}

		for (int i : sortedArray2) {
			treeMap.put(i, true);
		}

		int index = 0;
		int[] mergedArray = new int[sortedArray1.length + sortedArray2.length];
		
		for(Map.Entry<Integer, Boolean> mapEntry: treeMap.entrySet()) {
			mergedArray[index++] = mapEntry.getKey();
		}
		
		return mergedArray;
	}

	private static void mergeSortedArray(int[] sortedArray1, int[] sortedArray2) {
		System.out.println(Arrays.toString(sortedArray1) + " : " + Arrays.toString(sortedArray2));

		int[] resultArray = new int[sortedArray1.length + sortedArray2.length];

		int count = 0;

		for (int i = 0; i < sortedArray1.length || i < sortedArray2.length; i++) {
			if (sortedArray1.length > sortedArray2.length) {
				if (i <= sortedArray1.length - 1 && i <= sortedArray2.length - 1) {
					if (sortedArray1[i] < sortedArray2[i]) {
						resultArray[count++] = sortedArray1[i];
						resultArray[count++] = sortedArray2[i];
					} else {
						resultArray[count++] = sortedArray2[i];
						resultArray[count++] = sortedArray1[i];
					}
				} else {
					if (resultArray[count - 1] > sortedArray1[i]) {
						int temp = resultArray[count - 1];
						resultArray[count - 1] = sortedArray1[i];
						resultArray[count++] = temp;
					} else {
						resultArray[count++] = sortedArray1[i];
					}
				}
			} else {
				if (i <= sortedArray1.length - 1 && i <= sortedArray2.length - 1) {
					if (sortedArray1[i] < sortedArray2[i]) {
						resultArray[count++] = sortedArray1[i];
						resultArray[count++] = sortedArray2[i];
					} else {
						resultArray[count++] = sortedArray2[i];
						resultArray[count++] = sortedArray1[i];
					}
				} else {
					if (resultArray[count - 1] > sortedArray2[i]) {
						int temp = resultArray[count - 1];
						resultArray[count - 1] = sortedArray2[i];
						resultArray[count++] = temp;
					} else {
						resultArray[count++] = sortedArray2[i];
					}
				}
			}
		}

		System.out.println(Arrays.toString(resultArray));
	}

}
