import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
//        checkSSN("999-999-999");
//        phoneNumber("(253)2932668");
//        email("ianlean@uw.edu");
//        classRoster("Ian, McLean, S");
        date("03-31-2000");
    }

    public static boolean date(String s) {
        String[] regex = {"(0[(469)]|(11))-(0[1-9]|1[1-9]|2[1-9]|30)-([0-9][0-9][0-9][0-9])"
                , "(0[(13578)]|1(02))-(0[1-9]|1[1-9]|2[1-9]|3[0-1])-([0-9][0-9][0-9][0-9])"
                , "(02)(0[1-9]|1[0-9]|2[0-8][0-9][0-9][0-9][0-9])",
                "(02)29(([0-9][0-9](04|08|[2468][048]|[13579][26]))|2000)"
        };

        System.out.println(regex[1]);

        Pattern pattern = Pattern.compile(regex[1]);

        Matcher matcher = pattern.matcher(s);

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " << %s >> starting at " +
                            "index %d and ending at index %d.\n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
        System.out.println(Pattern.matches(regex[1],s));
        return found;
    }

    public static boolean classRoster(String s) {
        String regex = "[A-Z][a-z]*((,)(\\s))[A-Za-z]+((,)(\\s)[A-Z]?)?";

        System.out.println(regex);

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(s);

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " << %s >> starting at " +
                            "index %d and ending at index %d.\n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
        System.out.println(Pattern.matches(regex,s));
        return found;
    }
    public static boolean email(String s) {
        String regex = "[-A-Za-z0-9!#$%&’*+/=?^_`{|}~-]+@[A-Za-z0-9_.%]+\\.[A-Za-z]+";

        System.out.println(regex);

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(s);

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " << %s >> starting at " +
                            "index %d and ending at index %d.\n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
        System.out.println(Pattern.matches(regex,s));
        return found;
    }
    public static boolean phoneNumber(String s) {
        String regex = "[(]*\\d{3}[)|\\s]*\\d{3}(-||\\s)*\\d{4}";

        System.out.println(regex);

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(s);

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " << %s >> starting at " +
                            "index %d and ending at index %d.\n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
        System.out.println(Pattern.matches(regex,s));
        return found;
    }
    public static boolean checkSSN(String s) {
        String regex = "\\d{3}(-||\\s)*\\d{3}(-||\\s)*\\d{3}";

        System.out.println(regex);

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(s);

        boolean found = false;
        while (matcher.find()) {
            System.out.printf("I found the text" +
                            " << %s >> starting at " +
                            "index %d and ending at index %d.\n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
        System.out.println(Pattern.matches(regex,s));
        return found;
    }
}