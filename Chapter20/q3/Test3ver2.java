package Chapter20.q3;

import java.util.*;

public class Test3ver2 {
    public static void main(String[] args) {
        HashMap<String , String > map = new HashMap<>();
        map.put("Alabama", "Montgomery");
        map.put("Alaska", "Juneau");
        map.put("Arizona", "Phoenix");
        map.put("Arkansas", "Little Rock");
        map.put("California", "Sacramento");
        map.put("Colorado", "Denver");
        map.put("Connecticut", "Hartford");
        map.put("Delaware", "Dover");
        map.put("Florida", "Tallahassee");
        map.put("Georgia", "Atlanta");
        map.put("Hawaii", "Honolulu");
        map.put("Idaho", "Boise");
        map.put("Illinois", "Springfield");
        map.put("Maryland", "Annapolis");
        map.put("Minnesota", "Saint Paul");
        map.put("Iowa", "Des Moines");
        map.put("Maine", "Augusta");
        map.put("Kentucky", "Frankfort");
        map.put("Indiana", "Indianapolis");
        map.put("Kansas", "Topeka");
        map.put("Louisiana", "Baton Rouge");
        map.put("Oregon", "Salem");
        map.put("Oklahoma", "Oklahoma City");
        map.put("Ohio", "Columbus");
        map.put("North Dakota", "Bismark");
        map.put("New York", "Albany");
        map.put("New Mexico", "Santa Fe");
        map.put("New Jersey", "Trenton");
        map.put("New Hampshire", "Concord");
        map.put("Nevada", "Carson City");
        map.put("Nebraska", "Lincoln");
        map.put("Montana", "Helena");
        map.put("Missouri", "Jefferson City");
        map.put("Mississippi", "Jackson");
        map.put("Massachusettes", "Boston");
        map.put("Michigan", "Lansing");
        map.put("Pennslyvania", "Harrisburg");
        map.put("Rhode Island", "Providence");
        map.put("South Carolina", "Columbia");
        map.put("South Dakota", "Pierre");
        map.put("Tennessee", "Nashville");
        map.put("Texas", "Austin");
        map.put("Utah", "Salt Lake City");
        map.put("Vermont", "Montpelier");
        map.put("Virginia", "Richmond");
        map.put("Washington", "Olympia");
        map.put("West Virginia", "Charleston");
        map.put("Wisconsin", "Madison");
        map.put("Wyoming", "Cheyenne");

        int correctCount = 0;
        Scanner input = new Scanner(System.in);

        for(String key : map.keySet()) {

            System.out.print("What is the capital of " + key + "?");

            String capital = input.nextLine();

            if (capital.equals(map.get(key))) {
                System.out.println("Your anwswer is correct");
                correctCount++;
            } else
                System.out.println("The correct answer should be " + map.get(key));
        }
            System.out.println("The correct count is " + correctCount);

    }
}
