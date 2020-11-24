package Chapter22.q2;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s = input.nextLine();
        System.out.println("Maximum increasing ordered subsequence is " + maxSubstring(s) );
    }

    public static String maxSubstring(String s){
        int[] maxLength = new int[s.length()];
        int[] previous = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            previous[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) > s.charAt(j) &&
                        maxLength[i] < maxLength[j] + 1) {
                    maxLength[i] = maxLength[j] + 1;
                    previous[i] = j;
                }
            }
        }

        // Find the largest subsequence length and ending index
        int maxL = maxLength[0];
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (maxL < maxLength[i]) {
                maxL = maxLength[i];
                index = i;
            }
        }

        // Construct the subsequence by tracing through previous
        char[] chars = new char[maxL + 1];
        int i = maxL;
        while (index != -1) {
            chars[i--] = s.charAt(index);
            index = previous[index];
        }

        return new String(chars);

    }
    
}
