import com.google.common.io.Resources;
import kotlin.text.Charsets;

import java.io.IOException;

public class ReadFromFile {

    public static void main(String[] args) throws IOException {
        String personalData = Resources.toString(
                Resources.getResource("dp_response.json"
                ), Charsets.UTF_8);

        String someStr = Resources.toString(
                Resources.getResource("other.json"
                ), Charsets.UTF_8);

        System.out.println(someStr);
        System.out.println(personalData);

        if (someStr.equals(personalData)) System.out.println("EQUALS");

    }
}
