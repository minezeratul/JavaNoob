package cuzWhyNotCoding;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class is_Anagram {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println("result is " + isAnagram(s , t));
        System.out.println("result is " + isAnagram2(s , t));

        
    }

    //my version 4ms 38.7ms
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] temp = new int[26];
        Arrays.fill(temp, 0);

        for (int i = 0 ; i < s.length() ; i++)
            temp[(int) (s.charAt(i)) - 'a']++;

        for (int j = 0 ; j < t.length() ; j++)
            temp[(int) (t.charAt(j)) - 'a']--;

        for (int k = 0; k < 26; k++)
            if (temp[k] != 0)
                return false;

        return true;
    }

    //improved my solution
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] temp = new int[26];
        Arrays.fill(temp, 0);

        for (int i = 0 ; i < s.length() ; i++)
            temp[(int) (s.charAt(i)) - 'a']++;

        for (int j = 0 ; j < t.length() ; j++) {
            temp[(int) (t.charAt(j)) - 'a']--;
            if (temp[(int) (t.charAt(j)) - 'a'] < 0)
                return false;
        }
        return true;
    }

    //O(n) O(S）official hashtable
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

}
