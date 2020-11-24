package chapter23.Pratice;

import java.util.Arrays;

public class SelectionLife {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 3, 1, 5};
        System.out.println(Arrays.toString(SelectionSort(arr)));

        int[] arr2 = {};
        System.out.println(Arrays.toString(SelectionSort(arr2)));

    }

    public static int[] SelectionSort(int[] arr){
        if (arr.length == 0)
            return arr;
        for (int i = 0 ; i < arr.length ; i++){
            int minIndex = i ;
            for (int j = i ; j < arr.length ; j ++){
                if (arr[j] < arr[minIndex])
                    minIndex = j ;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
