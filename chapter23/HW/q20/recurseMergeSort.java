package chapter23.HW.q20;

import java.util.Arrays;

public class recurseMergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 2, 4, 8, 6 , 0 , 7};
        recurseMergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void recurseMergeSort(int[] arr){
        recurseMergeSort(arr , 0 , arr.length - 1);
    }

    public static void  recurseMergeSort(int[] arr , int first , int last){
        if (first < last){
            int mid = (first + last) / 2;
            recurseMergeSort(arr , first , mid);
            recurseMergeSort(arr , mid + 1 , last);
            int[] temp = merge(arr , first , last);
            System.arraycopy(temp  , 0 , arr , first , last - first + 1);
        }
    }

    /*
    it seems that there are two arrays
    one is [0] to [mid]
    another is [mid + 1] to high
     */
    public static int[] merge(int[] arr , int low , int high){
        int[] temp = new int[high - low + 1];
        int mid = (low + high) / 2;

        int current1 = low; // Current index in list1
        int current2 = mid + 1; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 <= mid && current2 <= high) {
            if (arr[current1] < arr[current2])
                temp[current3++] = arr[current1++];
            else
                temp[current3++] = arr[current2++];
        }

        while (current1 <= mid)
            temp[current3++] = arr[current1++];
        while (current2 <= high)
            temp[current3++] = arr[current2++];


        return temp;
    }
}
