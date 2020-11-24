package chapter23.Pratice;

import java.util.Arrays;

public class QuickLife {
    public static void main(String[] args) {
        int[] arr = {5 ,2 ,9 ,3 ,8 ,4 ,0 ,1 ,6 ,7 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void quickSort(int[] arr){
        quickSort(arr , 0 , arr.length - 1);
    }
    
    public static void quickSort(int[]arr , int first , int last){
        if (last > first){
            int pivotIndex = partition(arr , first , last);
            quickSort(arr , first , pivotIndex - 1);
            quickSort(arr , pivotIndex + 1, last);
        }
    }

    public static int partition(int[]arr , int first , int last){
        int pivot = arr[first];
        int low = first + 1;
        int high = last;

        while (high > low){
            //Search left to right
            while (high >= low && arr[low] <= pivot){
                low++;
            }

            //Search right to left
            while (high >= low && arr[high] > pivot){
                high--;
            }

            if (high > low){  //swap the element in the array
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }

        while (high > first && arr[high] >= pivot){
            high--;
        }

        //swap the pivot
        if (pivot > arr[high]){
            arr[first] = arr[high];
            arr[high] = pivot;
            return high;
        }
        else
            return first;

    }

}
