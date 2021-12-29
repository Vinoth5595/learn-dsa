package learn.coding;

import java.util.HashSet;
import java.util.Set;

public class PrintPairs {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int n = 16;
        printpairs(arr, n);
    }

    private static void printpairs(int[] arr, int sum) {
        Set<Integer> hashSet = new HashSet<>();

        for(int i: arr){
            int temp = sum - i;

            if(hashSet.contains(temp)){
                System.out.printf("Pair is : %s and %s", temp, i);
            }

            hashSet.add(i);
        }
    }
}
