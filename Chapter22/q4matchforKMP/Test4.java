package Chapter22.q4matchforKMP;

import java.util.Scanner;

public class Test4 {
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

    }

    public static int match(String s , String pattern){
        int k = 0;

        for (int p = 0; p < s.length(); p++) {
            for (int i = p; i < s.length(); i++) {

                if (k == pattern.length())
                    return i - pattern.length();
                else {
                    if (s.charAt(i) == pattern.charAt(k))
                        k++;
                    else
                        break;//stop and get the matched string
                }
            }

            if (k == pattern.length())
                return s.length() - pattern.length();
        }

        return -1;
    }
}
