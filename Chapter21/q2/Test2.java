package Chapter21.q2 ;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Test fullfilename");
            System.exit(1);
        }

        String filename = args[0];

        TreeSet<String> treeSet = new TreeSet<String>();

        try {
            Scanner input = new Scanner(new File(filename));
            String line;

            while ((line = input.nextLine()) != null) {
                String[] tokens = line.split("[ |\n|\t|\r|.|,|)|(|-|\"]");

                for (int i = 0; i < tokens.length; i++)
                    treeSet.add(tokens[i]);
            }

            input.close();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        Iterator iterator = treeSet.iterator();

        System.out.println("\nDisplay words in ascending order ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
