package Chapter21.q14;

import java.net.URL;
import java.util.*;

public class Test14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url);
    }

    public static void crawler(String startingURL) {
        LinkedList<String> queue = new LinkedList<String>();
        Set<String> S = new HashSet<String>();

        queue.add(startingURL);
        while (!queue.isEmpty()) {
            String urlString = queue.poll();
            if (!S.contains(urlString)) {
                System.out.println("Craw " + urlString);
                S.add(urlString);
            }
            if (S.size() >= 100)
                break;
            for (String s: getSubURLs(urlString)) {
                if (!S.contains(s))
                    queue.add(s);


            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<String>();

        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                if (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0)
                        list.add(line.substring(current, endIndex));
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;

    }
}
