package Chapter18.q30;//delete it before using

import java.io.File;
import java.util.Scanner;

public class FindWord {
    public static void main(String[] args) {
    if (args.length != 2) {
    System.out.println("Usage: java FindWord directoryName word");
    System.exit(0);
}

    findInFile(new File(args[0]), args[1]);
}

    public static long findInFile(File file, String word) {
        long numberOfFiles = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                findInFile(files[i], word);
            }
        }
        else {
            findWord(file, word);
            numberOfFiles++;
        }

        return numberOfFiles;
    }

    public static void findWord(File file, String word) {
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.indexOf(word) > -1) {
                    System.out.println(file + ": " + line);
                }
            }
            input.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}