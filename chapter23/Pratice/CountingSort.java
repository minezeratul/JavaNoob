package chapter23.Pratice;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));


        int[] arr2 = {2 , 2, 3 , 11 ,7 , 5 ,8};
        System.out.println(Arrays.toString(arr2));
        countingSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] countingSort(int[] arr){
        if (arr.length == 0)//false array
            return arr;
        int bias , min = arr[0] , max = arr[0];

        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] > max) //swap the maximum
                max = arr[i];
            if (arr[i] < min)//swap the minimum
                min = arr[i];
        }

        bias = 0 - min; //偏差值

        int[] bucket = new int[max - min + 1];//the times of the elements appear
        Arrays.fill(bucket, 0);//set the time of appear
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] + bias]++;
        }

        int index = 0, i = 0;

        while (index < arr.length) {
            if (bucket[i] != 0) { //反向填充数组
                arr[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }

     return arr;
    }
}

/*
步骤1：找出待排序的数组中最大和最小的元素；
步骤2：统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
步骤3：对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
步骤4：反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */