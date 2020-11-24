package chapter23.Pratice;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        
        int[] arr = {6 , 5 , 7 , 8 , 2 ,9 , 3 ,1 ,4};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    
    public static void insertionSort(int[] arr){
        for (int i = 1 ; i < arr.length ; i++){ //从list[1]开始比较，不用从index=0开始
            int current = arr[i];
            int k ;
            for (k = i - 1 ; k >= 0 && arr[k] > current ; k--){
                arr[k + 1] = arr[k];
            }

            arr[k + 1] = current;
        }

    }

}
