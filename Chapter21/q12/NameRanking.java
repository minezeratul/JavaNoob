package Chapter21.q12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NameRanking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename : ");
        String filename = input.nextLine();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File " + file + " does not exist");
            System.exit(-1);
        }

        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Set<String> boyNames = new HashSet<String>();
        Set<String> girlNames = new HashSet<String>();

        while (input.hasNext()) {
            input.nextInt(); // Skip an integer for ranking
            boyNames.add(input.next());
            input.nextInt(); // Skip an integer for number of boys
            girlNames.add(input.next());
            input.nextInt(); // Skip an integer for number of girls
        }

        boyNames.retainAll(girlNames);
        System.out.println(boyNames.size() + " names are used for both boys and girls ");
        System.out.println("They are ");
        // for (String name: boyNames) {
        //    System.out.print(name + " "); }

        boyNames.forEach(name -> System.out.print(name + " "));
    }

}
