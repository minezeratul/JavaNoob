package chapter23.Pratice;

import java.util.Arrays;

public class MergeLife {
    public static void main(String[] args) {
        int[] arr = {2 , 9 , 5 , 4 ,8 ,1 ,6 ,7 };// when elements are not 2n , it will go wrong
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr){
        if (arr.length > 1){

            int[] firstHalf = new int[arr.length/2];
            System.arraycopy(arr , 0 , firstHalf , 0 ,arr.length / 2);
            mergeSort(firstHalf);

            int[] secondHalf = new int[arr.length/2];
            System.arraycopy(arr , arr.length/2 , secondHalf ,0, secondHalf.length );
            mergeSort(secondHalf);

            merge(firstHalf , secondHalf , arr);
            
        }
    }
    
    public static void merge(int[] firstHalf ,int[] secondHalf ,int[] temp){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (firstHalf[current1] < secondHalf[current2])
                temp[current3++] = firstHalf[current1++];
            else
                temp[current3++] = secondHalf[current2++];
        }

        while (current1 < firstHalf.length)
            temp[current3++] = firstHalf[current1++];

        while (current2 < secondHalf.length)
            temp[current3++] = secondHalf[current2++];
    }
}
