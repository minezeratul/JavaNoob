package Chapter25BST.pratice;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7 , 6 , 9 ,0 , 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(BinarySearch(arr , 7));
    }

    public static int BinarySearch(int[] arr , int target){//search before sorting
        int left = 0 ;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return -1;
    }
}
