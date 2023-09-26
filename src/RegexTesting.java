import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


/**
 * Specific regex requirements are in each method of Regex.java
 * @see Regex
 *
 * Ian McLean
 * Regex Assignment
 * TCSS483
 * Spring 2023
 *
 * This testing file was made by David Huynh. I have edited the file with
 * my own test as our regex's are slightly different in what they require.
 */
class RegexTesting {

    /**
     * @see Regex#checkSSN(String)
     */
    @Test
    void regexSSN() {
        System.out.println("\nregex1SSN" + "------------------------------");
        assertTrue(Regex.checkSSN("123-12-1234"));
        assertTrue(Regex.checkSSN("123121234"));
        assertTrue(Regex.checkSSN("123 12 1234"));
        assertTrue(Regex.checkSSN("123-12-1234"));
        assertTrue(Regex.checkSSN("999999999"));

        assertFalse(Regex.checkSSN("12D-12-0000"));// extra credit
        assertFalse(Regex.checkSSN("000-12-1234"));//extra credit
        assertFalse(Regex.checkSSN("666-12-1465"));// extra credit

        assertFalse(Regex.checkSSN("123-1D-1234"));
        assertFalse(Regex.checkSSN("123-12-12a4"));
        assertFalse(Regex.checkSSN("1234-12-1234"));
        assertFalse(Regex.checkSSN("123-123-1234"));
        assertFalse(Regex.checkSSN("123-12-12345"));
        assertFalse(Regex.checkSSN("1234121234"));
        assertFalse(Regex.checkSSN("1234 123 12345"));
        assertFalse(Regex.checkSSN("true 234-12-1234"));
        assertFalse(Regex.checkSSN("123-121234"));
        assertFalse(Regex.checkSSN("12312-1234"));
    }

    /**
     * @see Regex#phoneNumber(String) 
     */
    @Test
    void phoneNumber() {
        System.out.println("phoneNumber()" + "------------------------------");
        assertEquals(true,Regex.phoneNumber("2531231234"));
        assertEquals(true,Regex.phoneNumber("(253)123-1234"));
        assertEquals(true,Regex.phoneNumber("(253123-1234"));
        assertEquals(true,Regex.phoneNumber("253)123-1234"));
        assertEquals(true,Regex.phoneNumber("253123-1234"));
        assertEquals(true,Regex.phoneNumber("253 123-1234"));
        assertEquals(true,Regex.phoneNumber("(253)1231234"));
        assertEquals(false,Regex.phoneNumber("(253)12341234"));
        assertEquals(false,Regex.phoneNumber("253 123 a234"));
        assertEquals(false,Regex.phoneNumber("true 253 123 1234"));
        assertEquals(false,Regex.phoneNumber("571-223-1d45"));
        assertEquals(false,Regex.phoneNumber("phone number"));
    }

    /**
     * @see Regex#email(String)
     */
    @Test
    void email() {
        System.out.println("\nemail()" + "------------------------------");
        assertEquals(true, Regex.email("ianlean@gmail.com"));
        assertEquals(true, Regex.email("boingodoingo@gmail.com.gov.co"));
        assertEquals(true, Regex.email("bdarn@gmail.com"));
        assertEquals(true, Regex.email("no_reply@uw.edu"));
        assertEquals(true, Regex.email("dude.a.person.mil@army.mil"));

        assertEquals(false, Regex.email("oh_no@gmail.com.gov.co."));
        assertEquals(false, Regex.email("bruh@gmail."));
        assertEquals(false, Regex.email("@gmail.com"));
        assertEquals(false, Regex.email("thingyyahoo.com"));
        assertEquals(false, Regex.email("bruh@.com"));
        assertEquals(false, Regex.email("bruhgmail.com"));
        assertEquals(false, Regex.email("&@gmail.com"));
        assertEquals(false, Regex.email("!bruh@gmail.com"));
        assertEquals(false, Regex.email("bruh$@gmail.com"));
        assertEquals(false, Regex.email("br!!uh@gmail.com"));
    }

    /**
     * @see Regex#classRoster(String)
     */
    @Test
    void classRoster() {
        System.out.println("\nclassRoster()" + "------------------------------");
        assertEquals(true, Regex.classRoster("Last, First, M"));
        assertEquals(false, Regex.classRoster(", First, M"));
        assertEquals(false, Regex.classRoster("         Last, First, M"));
        assertEquals(true, Regex.classRoster("McLean, Ian, S"));
        assertEquals(true, Regex.classRoster("Last, Mary-Jane, H"));
        assertEquals(true, Regex.classRoster("O'Neill, Irish, H"));
        assertEquals(true, Regex.classRoster("Hills, De'Ante, B"));
        assertEquals(false, Regex.classRoster("Huynh, Gia-Bao (David), Huu"));
        assertEquals(false, Regex.classRoster("Last, First, Middle"));
        assertEquals(false, Regex.classRoster("Last First M"));
        assertEquals(false, Regex.classRoster("Last, First M"));
        assertEquals(false, Regex.classRoster("Last First, M"));
    }

    /**
     * @see Regex#date(String)
     */
    @Test
    void date() { //MM-DD-YYYY
        System.out.println("\ndate" + "------------------------------");
        assertEquals(true, Regex.date("01-01-2023"));
        assertEquals(true, Regex.date("01/01/2023"));
        assertEquals(false, Regex.date("true-true-2023"));
        assertEquals(false, Regex.date("true/true/2023"));
        assertEquals(false, Regex.date("02/29/2001"));
        assertEquals(true, Regex.date("02-28-2001"));
        assertEquals(true, Regex.date("02-29-2000"));
        assertEquals(true, Regex.date("02-29-2004"));
        assertEquals(true, Regex.date("02-29-2008"));
        assertEquals(true, Regex.date("02-29-2048"));
        assertEquals(false, Regex.date("02-29-2001"));
        assertEquals(false, Regex.date("04/31/2001"));
        assertEquals(true, Regex.date("04/30/2001"));
        assertEquals(false, Regex.date("13/true/2023"));
        assertEquals(false, Regex.date("12/32/2023"));
        assertEquals(false, Regex.date("99/99/2023"));
        assertEquals(false, Regex.date("false/false/2023"));
        assertEquals(false, Regex.date("true-true/2023"));
        assertEquals(false, Regex.date("true/true-2023"));
    }

    /**
     * @see Regex#houseAddress(String)
     */
    @Test
    void houseAddress() {
        System.out.println("\nhouseAddress" + "------------------------------");
        assertEquals(true, Regex.houseAddress("910 S 77nd St"));
        assertEquals(true, Regex.houseAddress("31750 14th Way SW"));
        assertEquals(true, Regex.houseAddress("252 Broadway"));
        assertEquals(true, Regex.houseAddress("910 S. 77nd St."));
        assertEquals(true, Regex.houseAddress("910 S. 77nd Blvd."));
        assertEquals(true, Regex.houseAddress("910 s. 77nd blvd"));
        assertEquals(true, Regex.houseAddress("84 South Rock Maple Ave."));
        assertEquals(true, Regex.houseAddress("84 South Rock Maple Ave."));
        assertEquals(true, Regex.houseAddress("84 South Rock Maple Avenue"));
        assertEquals(false, Regex.houseAddress("84 South Rock Maple Aven."));
        assertEquals(false, Regex.houseAddress("South Rock Maple Ave"));
        assertEquals(false, Regex.houseAddress("2134 South street name way too long lol st."));
        assertEquals(false, Regex.houseAddress("345 "));
        assertEquals(false, Regex.houseAddress("345road st"));
        assertEquals(false, Regex.houseAddress("345 road !!!!"));
    }

    /**
     * @see Regex#cityAndState(String)
     */
    @Test
    void cityAndState() {
        System.out.println("\ncityAndState()" + "------------------------------");
        assertEquals(true, Regex.cityAndState("Tacoma, WA 12345"));
        assertEquals(true, Regex.cityAndState("Tacoma, WA 12345"));
        assertEquals(true, Regex.cityAndState("NYC, NY 12345-1234"));
        assertEquals(true, Regex.cityAndState("Tacoma, WA 98402"));
        assertEquals(true, Regex.cityAndState("Seattle, CA 71123"));
        assertEquals(false, Regex.cityAndState("Tacoma,WA 12345-"));
        assertEquals(false, Regex.cityAndState("Tacoma, WA 1234"));
        assertEquals(false, Regex.cityAndState("Tacoma, WA 123456"));
        assertEquals(false, Regex.cityAndState("Tacoma WA 12345"));
        assertEquals(false, Regex.cityAndState("Tacoma, WA 1234-1234"));
        assertEquals(false, Regex.cityAndState("Tacoma, WA 12345-12345"));
        assertEquals(false, Regex.cityAndState("Tacoma, WZ 12345"));
    }

    /**
     * @see Regex#time(String)
     */
    @Test
    void time() {
        System.out.println("\ntime()" + "------------------------------");
        assertEquals(true, Regex.time("0000"));
        assertEquals(true, Regex.time("0500"));
        assertEquals(true, Regex.time("1000"));
        assertEquals(true, Regex.time("1500"));
        assertEquals(true, Regex.time("2359"));
        assertEquals(false, Regex.time("500"));
        assertEquals(false, Regex.time("0060"));
        assertEquals(false, Regex.time("2400"));
        assertEquals(false, Regex.time("12450"));
        assertEquals(false, Regex.time("17 30"));
    }

    /**
     * @see Regex#currency(String)
     */
    @Test
    void currency() {
        System.out.println("\ncurrency()" + "------------------------------");
        assertEquals(true, Regex.currency("$123,456,789.23"));
        assertEquals(true, Regex.currency("123,456,789.23"));
        assertEquals(true, Regex.currency("$123456789.23"));
        assertEquals(false, Regex.currency("$123456,789.23"));
        assertEquals(false, Regex.currency("$123,456789.23"));
        assertEquals(true, Regex.currency("$23,456,789.23"));
        assertEquals(true, Regex.currency("$2,456,789.23"));
        assertEquals(true, Regex.currency("$456,789.23"));
        assertEquals(true, Regex.currency("$56,789.23"));
        assertEquals(true, Regex.currency("$6,789.23"));
        assertEquals(true, Regex.currency("$789.23"));
        assertEquals(true, Regex.currency("$89.23"));
        assertEquals(true, Regex.currency("$9.23"));
        assertEquals(true, Regex.currency("$0.23"));
        assertEquals(true, Regex.currency("$1,000"));
        assertEquals(false, Regex.currency("$1,000.false"));
        assertEquals(false, Regex.currency("$123,456,789.2"));
        assertEquals(false, Regex.currency("$123,45,789.23"));
        assertEquals(false, Regex.currency("$123,456,78.23"));
        assertEquals(true, Regex.currency("$0.23"));
        assertEquals(true, Regex.currency("$.23"));
        assertEquals(false, Regex.currency("$wasdw.23"));
    }

    /**
     * @seeRegex#URL()(String)
     */
    @Test
    void URL() {
        System.out.println("\nURL()" + "------------------------------");
        assertEquals(true,Regex.URL("https://www.google.com"));
        assertEquals(true,Regex.URL("https://www.google.com/"));
        assertEquals(true,Regex.URL("www.google.com"));
        assertEquals(true,Regex.URL("www.google.com/"));
        assertEquals(true,Regex.URL("https://www.regular-expressions.info/quickstart.html"));
        assertEquals(true,Regex.URL("https://docs.oracle.com/javase/tutorial/essential/regex/bounds.html"));
        assertEquals(true,Regex.URL("https://canvas.uw.edu/courses/1642545/assignments/8223051"));
        assertEquals(false,Regex.URL("https//canvas.uw.edu/courses/1642545/assignments/8223051"));
        assertEquals(false,Regex.URL("https:/canvas.uw.edu/courses/1642545/assignments/8223051"));
        assertEquals(false,Regex.URL("https:/canvas.uw.edu/courses/1642545/assignments//8223051"));
        assertEquals(false,Regex.URL("https:canvas.uw.edu/courses/1642545/assignments/8223051"));
        assertEquals(false,Regex.URL("https:canvas.uw.edu/courses?"));
        assertEquals(false,Regex.URL("https://wwwgooglecom"));
        assertEquals(false,Regex.URL("wwwgooglecom"));
        assertEquals(false,Regex.URL("//:"));
        assertEquals(false,Regex.URL("www"));
        assertEquals(true,Regex.URL("google.com"));
        assertEquals(true,Regex.URL("https://cfb3-tcss450-labs-2021sp.herokuapp.com/doc/#api-Phish-GetPhishBlogGet"));
        assertEquals(true,Regex.URL("https://phishnet.api-docs.io/v3/blog/blog-get"));
        assertEquals(true,Regex.URL("https://cfb3-tcss450-labs-2021sp.herokuapp.com/phish/blog/get?message=wow"));
        assertEquals(true,Regex.URL("https://cfb3-tcss450-labs-2021sp.herokuapp.com/phish/blog/get?message=wow&test=2929"));
        assertEquals(true,Regex.URL("https://cfb3-tcss450-labs-2021sp.herokuapp.com/phish/blog/get?message="));
    }

    /**
     * @see Regex#password(String)
     */
    @Test
    void password() {
        System.out.println("\npassword()" + "------------------------------");
        assertEquals(true, Regex.password("Wasd123456!"));
        assertEquals(true, Regex.password("I'mSupeRC00l"));
        assertEquals(true, Regex.password("AmaZinGCoolPass018287*!,"));
        assertEquals(true, Regex.password("IAm.TheM1n"));
        assertEquals(true, Regex.password("IAm.TheMAXIMUMMMMMMMMMMWMWMWMmmmWW12345as"));
        assertEquals(false, Regex.password("I1mSupeRC00l"));
        assertEquals(false, Regex.password("I'mSupeRcool"));
        assertEquals(false, Regex.password("IAm.TheM1n2343 sdfg345 346 rtrgf d56"));
        assertEquals(false, Regex.password("IAm.TheM1"));
        assertEquals(false, Regex.password("wasd123456!"));
        assertEquals(false, Regex.password("Wasdwasdwasd123456!"));
        assertEquals(false, Regex.password("true"));
        assertEquals(false, Regex.password("www.google.com"));
        assertEquals(true, Regex.password("www.GoogLe.com/123"));
    }

    /**
     * @see Regex#ion(String)
     */
    @Test
    void ion() {
        System.out.println("\nion()()" + "------------------------------");
        assertEquals(true, Regex.ion("ion"));
        assertEquals(true, Regex.ion("quion"));
        assertEquals(true, Regex.ion("million"));
        assertEquals(true, Regex.ion("bruhion"));
        assertEquals(true, Regex.ion("wWOWOWOowwion"));
        assertEquals(false, Regex.ion("Trillion"));
        assertEquals(false, Regex.ion("POTION"));
        assertEquals(false, Regex.ion("lion"));
        assertEquals(false, Regex.ion("ow ion"));
        assertEquals(false, Regex.ion("ow-ion"));
        assertEquals(false, Regex.ion("ioningy"));
    }
}
