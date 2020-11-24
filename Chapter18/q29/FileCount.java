package Chapter18.q29;

import java.io.File;
import java.util.Scanner;

public class FileCount {
    public static void main(String[] args) {
        System.out.print("Enter a directory: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        System.out.println(getNumberOfFiles(new File(directory)) + " files");
    }

    public static long getNumberOfFiles(File file) {
        long numberOfFiles = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                numberOfFiles += getNumberOfFiles(files[i]);
            }
        }
        else {
            numberOfFiles++;
        }

        return numberOfFiles;
    }
}
