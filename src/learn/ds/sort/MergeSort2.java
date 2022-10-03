package learn.ds.sort;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] inputArray = {5, 4, 8, 9, -2, -5, 0};

        mergeSort(inputArray, 0, inputArray.length - 1);

        System.out.println(Arrays.toString(inputArray));
    }

    private static void mergeSort(int[] inputArray, int l, int r) {
        if(l < r){
            int mid = (l + r) / 2;

            mergeSort(inputArray, l, mid);
            mergeSort(inputArray, mid + 1, r);

            merge(inputArray, l, mid, r);
        }
    }

    private static void merge(int[] inputArray, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) L[i] = inputArray[l + i];
        for(int i = 0; i < n2; i++) R[i] = inputArray[m + 1 + i];

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                inputArray[k++] = L[i++];
            } else {
                inputArray[k++] = R[j++];
            }
        }

        while(i < n1){
            inputArray[k++] = L[i++];
        }

        while(j < n2){
            inputArray[k++] = R[j++];
        }
    }
}
