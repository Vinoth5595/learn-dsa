package learn.ds.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Quick Sort!");

        int[] input = {6, 7, 1, -1, -23, 5, 11, 3};
        quickSort(input, 0, input.length);

        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] input, int start, int end) {
        if(end - start < 2){
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j){
            while (i < j && input[--j] >= pivot);
            if(i < j) input[i] = input[j];

            while (i < j && input[++i] <= pivot);
            if(i < j) input[j] = input[i];
        }

        input[j] = pivot;
        return j;
    }
}
