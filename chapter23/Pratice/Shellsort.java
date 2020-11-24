package chapter23.Pratice;

import java.util.Arrays;

public class Shellsort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {8,9,1,7,2,3,5,4,6};
        ShellSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void ShellSort(int[] arr){
        int size = arr.length;
        int temp , gap = size / 2;
        //make the gap first
        while (gap > 0){
            //步骤1：选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
            for (int i = gap ; i < size ; i++){
                temp = arr[i];
                int preIndex = i - gap; //the left element
                //步骤2：按增量序列个数k，对序列进行k 趟排序
                while (preIndex >= 0 && arr[preIndex] > temp){// the right element
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                //
                arr[preIndex + gap] = temp ;
            }
            gap /= 2;//缩小gap的范围再调整
        }
    }
}
