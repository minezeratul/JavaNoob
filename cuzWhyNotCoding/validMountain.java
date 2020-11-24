package WhyNotCoding;

public class validMountain {
    public static void main(String[] args) {
        int[] a = {0 , 2 , 2 , 1};
        int[] b = {2 , 1};

        System.out.println( validMountainArray(a) );
        System.out.println( validMountainArray(b) );

    }

    //double pointer method
    public static boolean validMountainArray(int[] a){
        int low = 0 , high = a.length - 1;

        while (low < a.length - 1 && a[low] < a[low + 1])
            low++;
        while (high > 0 && a[high] < a[high - 1])
            high--;

        return low > 0 && high < a.length - 1 && low == high;

    }

    //Official answer
    public static boolean validMountainArray2(int[] A) {
            int N = A.length;
            int i = 0; // i is the sum of the decreasing arr and increasing arr

            // increasing array scanning
            while (i + 1 < N && A[i] < A[i + 1]) {
                i++;
            }

            // the lowest and highest couldn't be the mountain
            if (i == 0 || i == N - 1) {
                return false;
            }

            // decreasing array scanning
            while (i + 1 < N && A[i] > A[i + 1]) {
                i++;
            }

            return i == N - 1;

    }
}
