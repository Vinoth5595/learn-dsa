package learn.ds.sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        System.out.println("Quick Sort!");
        int[] input = {6, 7, 1, -1, -23, 5, 11, 3};

        quickSort(input, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] input, int start, int end) {
        if(start < end){
            int pivotIndex = partition(input, start, end);

            quickSort(input, start, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[end];
        int i = start - 1;

        for(int j = start; j < end; j++){

            if(input[j] <= pivot){
                i++;

                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        int temp = input[i + 1];
        input[i + 1] =  input[end];
        input[end] = temp;

        return i + 1;
    }
}
