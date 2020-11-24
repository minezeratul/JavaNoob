package Chapter18.q31;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java ReplaceWord directory oldWord newWord");
            System.exit(1);
        }

        replaceInFile(new File(args[0]), args[1], args[2]);
    }

    public static long replaceInFile(File file, String oldWord,
                                     String newWord) {
        long numberOfFiles = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                replaceInFile(files[i], oldWord, newWord);
            }
        }
        else {
            replaceWord(file, oldWord, newWord);
            numberOfFiles++;
        }

        return numberOfFiles;
    }

    public static void replaceWord(File file, String oldWord, String newWord) {
        String lineSeparator = System.getProperty("line.separator");
        String line = "";
        try {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    line += input.nextLine() + lineSeparator;
                }
            }

            if (line.indexOf(oldWord) > 0) {
                String newContent = line.replaceAll(oldWord, newWord);
                try (PrintWriter output = new PrintWriter(file)) {
                    output.print(newContent);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
