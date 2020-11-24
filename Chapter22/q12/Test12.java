package Chapter22.q12;

import java.io.*;

public class Test12 {
    public static void main(String[] args) throws IOException {
        DataInputStream input = new DataInputStream(new BufferedInputStream(
                        new FileInputStream("PrimeNumbers.dat")));

        try {
            input.skip(input.available() - 8 * 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!(input.available() > 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(input.readLong() + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        input.close();
    }
}
