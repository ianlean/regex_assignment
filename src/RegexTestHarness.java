
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class RegexTestHarness {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        while (true) {
            String regex;
            System.out.print("Enter your regex: ");
            regex = console.nextLine();
            Pattern pattern =
                    Pattern.compile(regex);
            String str;
            System.out.print("Enter input string to search: ");
            str = console.nextLine();
            Matcher matcher =
                    pattern.matcher(str);
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
        }
    }
}

