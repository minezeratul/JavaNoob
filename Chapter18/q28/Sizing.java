package Chapter18.q28;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sizing {
    public static void main(String[] args) {
        System.out.print("Enter a file or a directory: ");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();

        try {
            System.out.println();
            System.out.println("The size of \"" + path + "\" is " + getDirectorySize(new File(path), 30));
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static long getDirectorySize(File file, int depth) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file + " not found");
        }
        long totalSize = 0;

        if (file.isFile()) {
            return file.length();
        }
        else {
            int i = 0;
            int index = 0;
            int[] indices = new int[depth];
            boolean switcher = false;
            File[] files = file.listFiles();
            while (!switcher) {
                for (i = indices[index]; i < files.length; i++) {
                    if (files[i].isFile()) {
                        totalSize += files[i].length();
                        indices[index]++;
                    }
                    else {
                        File[] filesAux = files[i].listFiles();
                        if (filesAux.length != 0) {
                            indices[index]++;
                            index++;
                            files = filesAux;
                            indices[index] = 0;
                            i = -1;
                        }
                        else {
                            indices[index]++;
                        }
                    }
                }
                if (index == 0) {
                    switcher = true;
                }
                else {
                    index--;
                    files = new File(new File(files[i - 1].getParent()).getParent()).listFiles();
                }
            }
        }
        return totalSize;
    }

}
