package chapter23.Pratice;


public class BubbleLife {
    public static void main(String[] args) {
        int[] arr = {6 , 5 , 7 , 8 , 2 ,9 , 3 ,1 ,4};
        bubbleSort(arr);
        for (int temp : arr)
            System.out.print(temp + " ");
    }

    public static void bubbleSort(int[] arr){
        boolean needNextPass = true;

        for (int i = 1 ; i < arr.length && needNextPass ; i++){
            needNextPass = false;

            for (int k = 0 ; i < arr.length - k ; k++){ // arr[0]-----arr[k]

                if (arr[k] > arr [k + 1]){
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;

                    needNextPass = true;
                }            }
        }
    }
}
