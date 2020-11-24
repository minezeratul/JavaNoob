
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java Test fullfilename");
            System.exit(1);
        }

        String filename = args[0];

        ArrayList<String> list = new ArrayList<String>();

        try {
            Scanner input = new Scanner(new File(filename));

            String line;

            while (input.hasNext()) {
                line = input.nextLine();
                String[] words = line.split("[ \n\t\r.,:?)({}\\[\\]]");

                for (String word: words) {
                    if (word.trim().length() > 0 && word.trim().matches("\\w+"))
                        list.add(word.trim());
                }
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }

        Collections.sort(list);

        System.out.println("\nDisplay words in ascending order: ");
        for (String word: list) {
            System.out.print(word + " ");
        }
    }

}
