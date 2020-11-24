package cuzWhyNotCoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class intersection2arr {
    public static void main(String[] args) {
        int[] a = {1 ,2 ,2 ,1};
        int[] b = {2,2};

        System.out.println(Arrays.toString(intersection(a , b)));

        int[] c ={4 , 9 , 5};
        int[] d = {9 ,4 , 9 , 8 ,4 };
        System.out.println(Arrays.toString(intersection(c,d)));
    }

    public static int[] intersection(int[] arr1 , int[] arr2)
    {
        Set<Integer> arr = new HashSet<>();
        int i = 0 , j = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // int fakeNum = 0 ; 如果用fakeNum增大内存占用，但时复杂度下降，且应该用Integer.Min_Value
        //当数组为{8,0,3} {0,0} 会产生runtime error

        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i] == arr2[j]){
               arr.add(arr1[i]);
               i++;
               j++;
            }else if (arr1[i] < arr2[j])
                i++;
             else
                 j++;
        }

        int[] temp = new int[arr.size()];
        int k = 0;
        for (int num : arr)
            temp[k++] = num;

        return temp;
    }
}
