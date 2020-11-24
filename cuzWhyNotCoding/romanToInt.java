package WhyNotCoding;

public class romanToInt {
    public static void main(String[] args) {
        String s = "III" ; //145
        String s2 = "CXLV" ;
        System.out.println( transformRoman(s) + " " + transformRoman(s2));

    }

    //5ms version
    public static int transformRoman(String s){
        int count = 0 ;
        int size = s.length();

        for (int i = 0 ; i < size ; i++){
            if (i + 1 == size )
                count += getVal(s.charAt(i));
            else {
                if (getVal(s.charAt(i + 1)) <= getVal(s.charAt(i)))
                    count += getVal(s.charAt(i));
                else {
                    count += getVal(s.charAt(i + 1)) - getVal(s.charAt(i));
                    i++;
                }
            }
        }
        return count;
    }

    public static int getVal(char ch){
        switch (ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    //4ms version
    //class Solution {
    //        int count = 0 ;
    //        int size = s.length();
    //        int preNum = getVal(s.charAt(0));
    //
    //        for (int i = 1 ; i < size ; i++){
    //            int num = getVal(s.charAt(i));
    //            if (preNum < num)
    //                count -= preNum;
    //            else
    //                count += preNum;
    //
    //            preNum = num;
    //        }
    //        count += preNum;
    //
    //        return count;
    //    }
    //
    //    private int getValue(char ch){
    //        switch(ch) {
    //            case 'I':
    //            return 1;
    //            case 'V':
    //            return 5;
    //            case 'X':
    //            return 10;
    //            case 'L':
    //            return 50;
    //            case 'C':
    //            return 100;
    //            case 'D':
    //            return 500;
    //            case 'M':
    //            return 1000;
    //            default:
    //            return 0;
    //        }
    //    }
    //
}
