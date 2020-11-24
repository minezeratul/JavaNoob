package Chapter20.q8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        int lottery = (int)(Math.random() * 1000) ;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits): ");
        int guess = input.nextInt();

        int lottery1 = lottery / 100;
        int lottery2 = (lottery % 100) / 10;
        int lottery3 = lottery % 10;

        int guess1 = guess / 100;
        int guess2 = (guess % 100) / 10;
        int guess3 = guess % 10;

        List list1 = new ArrayList();
        list1.add(lottery1);
        list1.add(lottery2);
        list1.add(lottery3);
        Collections.sort(list1);

        List list2 = new ArrayList();
        list2.add(guess1);
        list2.add(guess2);
        list2.add(guess3);
        Collections.sort(list2);

        System.out.println("The lottery is " + lottery);
        System.out.println("Your guess is " + guess);

        if (guess  == lottery)
            System.out.println("Completely match:  $10,000");
        else if (list1.containsAll(list2))
            System.out.println("Match all digits:  $3,000");
        else if (list1.containsAll(list2.subList(0, 2)) || list1.containsAll(list2.subList(1, 3)))
            System.out.println("Match one digit:  $2,000");
        else if (list1.contains(guess1) || list1.contains(guess2) || list1.contains(guess3))
            System.out.println("Match one digit:  $1,000");
        else
            System.out.println("No match");

    }
}
