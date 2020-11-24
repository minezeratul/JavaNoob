package WhyNotCoding;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(s);
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String S){
        int[] words = new int[26];
        int length = S.length();

        for (int i = 0 ; i < length ; i++)
            words[S.charAt(i) - 'a'] = i;

        List<Integer> partition = new ArrayList<>();
        int partLeft = 0, partRight = 0;

        for (int i = 0 ; i < length ; i++){
            partRight = Math.max(partRight , words[S.charAt(i) - 'a']);

            if (partRight == i){
                partition.add(partRight - partLeft + 1);
                partLeft = partRight + 1;
            }
        }

        return partition;
    }
}
