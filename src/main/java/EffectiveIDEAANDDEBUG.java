import java.util.HashMap;
import java.util.Map;

/**
 * @author andreiserov
 */
public class EffectiveIDEAANDDEBUG {
    final static String helloWorld = "Hello world";
    private final Map<String, String> passwords = new HashMap<>();

    {
        passwords.put("google",     "google_pass");
        passwords.put("yandex",     "yandex_pass");
        passwords.put("youtube",    "youtube_pass");
        passwords.put("instagram",  "instagram_pass");

        println("App is ready");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            println(helloWorld);
            printEvens(i);
        }
    }



    private static void printEvens(int i) {
        if (i % 2 == 0) {
            println(String.valueOf(i));
        }
    }


    public static void println(String string) {
        System.out.println(string);
    }

    public String fooBar(int number) {
        String result = "";

        if (number % 3 == 0) {
            result = result.concat("foo");
        }
        if (number % 5 == 0) {
            result = result.concat("bar");
        }
        return result;
    }
}
