package Chapter22.q3match;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string1 : ");
        String s1 = input.nextLine();
        System.out.print("Enter string2 : ");
        String s2 = input.nextLine();

        int index = match(s1, s2);
        if (index >= 0)
            System.out.println("matched at index[" + index +"]");
        else
            System.out.println("No match");

        int index1 = match1(s1, s2);
        if (index >= 0)
            System.out.println("matched at index[" + index1 +"]");
        else
            System.out.println("No match");

    }

    // O(n) = n ,
    public static int match(String s, String pattern) {
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            if (k == pattern.length())
                return i - pattern.length();
            else {
                if (s.charAt(i) == pattern.charAt(k)) // if the nearby words are the same
                    k++;   // it will skip
                else
                    k = 0; //reset the string
            }
        }

        if (k == pattern.length())
            return s.length() - pattern.length();
        else
            return -1;
    }

    //brutal-force O(n^2)
    public static int match1(String s, String pattern) {

        for (int i = 0; i < s.length(); i++) {
            int k;
            for (k = 0 ; k < pattern.length(); k++) {
                if (s.charAt(i + k) != pattern.charAt(k))
                    break;
            }

            if (k == pattern.length())
                return i;
        }

        return -1;
    }
}
