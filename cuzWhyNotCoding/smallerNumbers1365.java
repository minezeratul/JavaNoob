package WhyNotCoding;

import java.util.Arrays;
import java.util.Comparator;

public class smallerNumbers1365 {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent1(arr)));
    }


    //Bruta-force O(n^2) S(1)
    public static int[] smallerNumbersThanCurrent(int[] nums){
        int l = nums.length;
        int[] temp = new int[l];

        for (int i = 0 ; i < l ; i++){
            int count = 0 ;

            for (int j = 0 ; j < l ; j++){
                if (nums[i] != nums[j])
                    if (nums[i] > nums[j])
                        count++;
            }
            temp[i] = count;
        }

        return temp;
    }

    //QuickSort O(NlogN) S(N)
    public static int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(data2 -> data2[0]));

        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }
}
