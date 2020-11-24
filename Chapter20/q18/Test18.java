package Chapter20.q18;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test18 {
    public static void main(String[] args) {
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file){
        long size = 0;

       Queue<File> queue = new LinkedList<File>();
       queue.offer(file);

        while (queue.size() > 0) {
            File temp = queue.remove();
            if (temp.isDirectory()) {
                File[] files = temp.listFiles();
                for (File f: files) {
                    queue.offer(f);
                }
            }
            else {
                size += temp.length();
            }
        }

        return size;
    }
}
