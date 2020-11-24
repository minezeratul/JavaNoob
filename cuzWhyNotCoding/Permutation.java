package WhyNotCoding;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 1, 5};
        int[] arr3 = {3, 2, 1};

        nextPermutation(arr1);
        nextPermutation(arr2);
        nextPermutation(arr3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }

    public static void nextPermutation(int[] nums) {//we should search from nums.length - 1.
        int length = nums.length;
        if (length < 2)
            return;//stop

        int i = length - 2 ;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0){
            int j = length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        reverse(nums , i + 1, length - 1);
    }

    public static void reverse(int[] arr , int start , int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    /* public static void nextPermutation(int[] nums){
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, length);

                for (int j = i; j < length ; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;

    } */
}