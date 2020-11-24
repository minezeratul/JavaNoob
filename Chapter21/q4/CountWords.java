package Chapter21.q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        HashSet<Character> set1 = new HashSet<Character>(Arrays.asList(new Character[]{'A', 'E', 'I', 'O', 'U'}));

        System.out.print("Enter a filename: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        try {
            input = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int countVowels = 0;
        int countConsonants = 0;

        while (input.hasNext()) {
            String s = input.nextLine().toUpperCase();
            for (int i = 0; i < s.length(); i++) {
                if (set1.contains(s.charAt(i)))
                    countVowels++;
                else if (Character.isLetter(s.charAt(i)))
                    countConsonants++;
            }
        }

        System.out.println("The number of vowels is " + countVowels + " and consonanats is " + countConsonants);
    }
}
