package chapter23.Pratice;

import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] arr = {1 , 11 , 121 , 2 , 21 , 3 , 4 ,32 , 112 ,1111 , 110 , 222};//3 = [300] = 百位 , 2 = [020] = 十位 , 1 = [001] = 个位
        radixSort(arr , 0);//ge
        System.out.println(Arrays.toString(arr));
        radixSort(arr , 1);//shi
        System.out.println(Arrays.toString(arr));
        radixSort(arr , 2);//bai
        System.out.println(Arrays.toString(arr));
        radixSort(arr , 3);//qian
        System.out.println(Arrays.toString(arr));
    }

    /** Sort the int array list. numberOfDigits is the number of digits
     * in the largest number in the array */
    public static void radixSort(int[] list, int numberOfDigits) {
        java.util.ArrayList<Integer>[] buckets = new java.util.ArrayList[10];//[0] .... [9]
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new java.util.ArrayList<Integer>();
        }

        for (int position = 0; position <= numberOfDigits; position++) {
            // Clear buckets
            for (int i = 0; i < buckets.length; i++) {
                buckets[i].clear();
            }

            // Distribute the elements from list to buckets
            for (int i = 0; i < list.length; i++) {
                int key = getKey(list[i], position);
                buckets[key].add(list[i]);
            }

            // Now move the elements from the buckets back to list
            int k = 0; // k is an index for list
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++)
                    list[k++] = buckets[i].get(j);
            }
        }
    }

    /** Return the digit at the specified position.
     * The last digit's position is 0. */
    public static int getKey(int number, int position) {
        int result = 1;
        for (int i = 0; i < position; i++)
            result *= 10;

        return (number / result) % 10;
    }

}
