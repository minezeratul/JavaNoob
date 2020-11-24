package Chapter20.q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.DirectoryNotEmptyException;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.print("Enter a file or a directory: ");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();

        try {
            System.out.println();
            System.out.println("The size of \"" + path + "\" is " + getDirectorySize(new File(path)));
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static long getDirectorySize(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file + " was not found");
        }

        long size = 0;

        Stack<File> stack = new Stack<File>();
        stack.push(file);

        while (!stack.empty()) {
            File t = stack.pop();
            if (t.isDirectory()) {
                File[] files = t.listFiles();
                for (File f: files) {
                    stack.push(f);
                }
            }
            else {
                size += t.length();
            }
        }

        return size;

    }
}
