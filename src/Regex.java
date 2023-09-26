import java.util.regex.Pattern;
/*
* Ian McLean
* Regex Assignment
* TCSS 483
* Spring 2023
 */
public class Regex {

    /*
        The Main method for this file, mostly for small testing purposes

        @param args - Command line args
     */
    public static void main(String[] args) {
        System.out.println(Regex.houseAddress("245 southwest st."));
    }

    /*
        Regex to house address, requires a number followed by an optional compass
        direction (Appreviation with period optional). The name of the street not including
        compass direction may be between 1 and 5 words in length. It can optionally include
        street, avenue,blvd etc.

        @param S - The address being tested.
        @return whether the input is valid.
     */
    public static boolean houseAddress(String s) {
        System.out.println(s);
        //String regex = "\\d+(\\s)((\\w(\\.)?|\\d(\\.)?)*\\s(\\w|\\d)*)(?i)(road|street|(st)(\\.)?|boulevard|blvd(\\.)?|avenue|ave(\\.)?)?";
        String regex = "(?i)\\d+(\\s((South|S)(\\.)?|(East|E)(\\.)?|(North|N)(\\.)?|(West|W)(\\.)?))?(\\s(\\w|\\d)+){1,5}(\\s(road|street|(st)(\\.)?|boulevard|blvd(\\.)?|avenue|ave(\\.)?))?";
        return Pattern.matches(regex, s);
    }
    /*
        Regex that checks for odd length words ending in ion
        case is ignored.

        @param S - The input being tested.
        @return whether the input is valid.
     */
    public static boolean ion(String s) {
        if (s.length() % 2 == 0) {return false;}
        String regex = "([A-Za-z]*)([Ii][Oo][Nn])";
        return Pattern.matches(regex,s);
    }

    /*
        Regex that validates the rules for a password.
        Allows any character, must be at least 10 characters long.
        Contains a lower case, an upper case,punctuation mark and no more
        than 3 consecutive lower case characters

        @param S - The password being tested.
        @return whether the input is valid.
     */
    public static boolean password(String s) {
        String regex = "(?=.*[a-z])(?!.*[a-z]{4})(?=.*[A-Z])(?=.*\\d)(?=.*[,.':;\\-\"\'!?]).{10,}";
        return Pattern.matches(regex,s);
    }
    /*
        Regex that validates a URL.
        This specific implementation allows for https://
        if the user wants it. The beginning name tag of the
        URL may not contain a colon as google documentation
        recommends only dashes and word characters. After the
        domain clause any amount and type of character is allowed.
        The URL must contain a domain clause between 2 and 4

        @param S - The URL being tested.
        @return whether the input is valid.
     */
    public static boolean URL(String s) {
        String regex = "(((http|HTTP|HTTPS|https)(://))?[a-zA-Z0-9-]+\\.([a-z]{1,4}+)([/a-zA-Z0-9@:%\\-&._\\+~?#=])*){1,2048}";
        return Pattern.matches(regex,s);
    }
    /*
        Regex to validate US currency. Dollar sign is
        optional. Cents are optional. If value is less than a dollar
        no 0 is necessary before the cents. Any number of digits are allowed.
        Commas are acceptable but must be formatted properly.

        @param S - The URL being tested.
        @return whether the input is valid.
     */
    public static boolean currency(String s) {
        String regex = "\\$?((0?|(\\d{1,3})(,\\d{3})*)?(\\.\\d{2})?)|" +
                "\\$?(0?|(\\d{1,3})(\\d{3})*(\\.\\d{2})?)";
        return Pattern.matches(regex,s);
    }

    /*
        Regex to validate 24 hour time. No colon allowed.
        time must be between 0000 and 2359.

        @param S - The time being tested.
        @return whether the input is valid.
     */
    public static boolean time(String s) {
        String regex = "([01]\\d|2[0-3])([0-5]\\d)";
        return Pattern.matches(regex,s);
    }

    /*
        Regex to validate city and state.
        Allows any city name

        @param S - The URL being tested.
        @return whether the input is valid.
     */
    public static boolean cityAndState(String s) {
        String regex = "[A-Za-z]+,(\\s)(AL|AK|AS|AZ|AR|CA" +
                "|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|" +
                "IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS" +
                "|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH" +
                "|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT" +
                "|VI|VA|WA|WV|WI|WY|)(\\s)(\\d{5})(-\\d{4})?";
        return Pattern.matches(regex,s);
    }

    /*
        Date regex that allows dash or slash no matter how stupid
        the combination of the two looks. Accurately checks for a valid
        date including leap years.


        @param S - The date format and validity to be tested
        @return whether the input is valid.
     */
    public static boolean date(String s) {
        String[] regex = {"(0[(469)]|(11))(-|/)(0[1-9]|1[1-9]|2[1-9]|30)(-|/)([0-9][0-9][0-9][0-9])"
                , "(0[(13578)]|1(02))(-|/)(0[1-9]|1[1-9]|2[1-9]|3[0-1])(-|/)([0-9][0-9][0-9][0-9])"
                , "(02)(-|/)(0[1-9]|1[0-9]|2[0-8])(-|/)[0-9][0-9][0-9][0-9]",
                "(02)(-|/)29(-|/)(([0-9][0-9](04|08|[2468][048]|[13579][26]))|2000)"
        };
        return Pattern.matches(regex[0], s) || Pattern.matches(regex[1], s) ||
                Pattern.matches(regex[2], s) || Pattern.matches(regex[3], s);
    }

    /*
        Regex that validated name on a class roster.
        Comma and space required. First and last names may be any length,
        middle must be one letter abbreviation. Hyphens, more than one
        capitol and apostrophes are allowed.

        @param S - The name being tested.
        @return whether the input is valid.
     */
    public static boolean classRoster(String s) {
        String regex = "[A-Za-z-']+((,)(\\s))[A-Za-z-']+((,)(\\s)[A-Z]?)?";
        return Pattern.matches(regex,s);
    }

    /*
        Regex that tests emails. The email name must start with a letter or digit.
        Essentially follows gmail naming email conventions

        @param S - The email being tested.
        @return whether the input is valid.
     */
    public static boolean email(String s) {
        String regex = "[A-Za-z0-9](?!.*\\W{2,}).*@[A-Za-z0-9_.%]+\\.[A-Za-z]{2,4}";
        return Pattern.matches(regex,s);
    }

    /*
        Regex that validates phone number
        allows paranthesis or dashes, must format properly.

        @param S - The number being tested.
        @return whether the input is valid.
     */
    public static boolean phoneNumber(String s) {
        String regex = "[(]*\\d{3}[)|\\s]*\\d{3}(-|\\s)*\\d{4}";
        return Pattern.matches(regex,s);
    }

    /*
        Regex that validates ssn. Must follow
        SSN number scheme convention (extra credit) and must contain proper
        amount of numbers and requires dashes.

        @param S - The name being tested.
        @return whether the input is valid.
     */
    public static boolean checkSSN(String s) {
        String regex = "(?!000|666)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}" +
                "|(?!000|666)\\d{3}(?!00) \\d{2}(?!0000) \\d{4}" +
                "|(?!000|666)\\d{3}(?!00)\\d{2}(?!0000)\\d{4}";
        return Pattern.matches(regex,s);
    }
}
