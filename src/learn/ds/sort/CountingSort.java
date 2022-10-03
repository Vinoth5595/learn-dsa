package learn.ds.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println("Counting Sort!");
        int[] input = {5, 7, 2, 4, 3, 2, 9, 8, 10};
        countingSort(input, 1, 10);
        System.out.println(Arrays.toString(input));
    }

    private static void countingSort(int[] input, int min, int max) {
        int[] temp = new int[(max - min) + 1];

        for(int i = 0; i < input.length; i++){
            temp[input[i] -  min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++){
            while(temp[i - min] > 0 ){
                input[j++] = i;
                temp[i - min]--;
            }
        }
    }
}
