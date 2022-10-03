package learn.ds.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, -1, -5, 9, 100, 34};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(end - start < 2){
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        if(input[mid - 1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
