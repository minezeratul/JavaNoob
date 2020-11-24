package Chapter21.q13;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test13 {
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];

    public Test13() {
        readNames();

        Scanner input = new Scanner(System.in);
        char anotherInput;

        do {
            System.out.print("Enter the year: ");
            int year = Integer.parseInt(input.nextLine());
            System.out.print("Enter the gender: ");
            char gender = input.nextLine().charAt(0);
            System.out.print("Enter the name: ");
            String name = input.nextLine();

            if (gender == 'M') {
                if (mapForBoy[year - 2001].containsKey(name))
                    System.out.println("Boy name " + name + " is ranked #" + mapForBoy[year - 2001].get(name) + " in year " + year);
                else
                    System.out.println("Boy name " + name  + " is not ranked in year " + year);
            }
            else {
                if (mapForGirl[year - 2001].containsKey(name))
                    System.out.println("Girl name " + name + " is ranked #" + mapForGirl[year - 2001].get(name) + " in year " + year);
                else
                    System.out.println("Girl name " + name + " is not ranked in year " + year);
            }

            System.out.print("Enter another inquiry? ");
            anotherInput = input.nextLine().charAt(0);
        }
        while (anotherInput != 'N');

        System.out.println("Done");
    }

    private void readNames() {
        try {
            for (int i = 0; i < 10; i++) {
                String filename;
                if (i == 9)
                    filename = "D:\\IDEA\\src\\text\\babynamesranking2010.txt";
                else
                    filename = "D:\\IDEA\\src\\text\\babynamesranking200" + (i + 1) + ".txt";
                File file = new File(filename);
                Scanner input = new Scanner(file);

                mapForBoy[i] = new HashMap<String, Integer>();
                mapForGirl[i] = new HashMap<String, Integer>();
                while (input.hasNext()) {
                    int ranking = input.nextInt();
                    String boyname = input.next();
                    input.nextInt(); // Skip the number of boy's name
                    String girlname = input.next();
                    input.nextInt(); // Skip the number of girl's name

                    mapForBoy[i].put(boyname, ranking);
                    mapForGirl[i].put(girlname, ranking);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Test13();
    }
}
