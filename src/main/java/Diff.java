import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.time.temporal.ChronoUnit;

public class Diff {
    private final String str1;
    {
        str1 = "first string";
    }
    private final String str2;
    {
        str2 = "second string";
    }

    @Override
    public String toString() {
        return "Diff{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Diff obj = new Diff();
        System.out.println(obj);
        String url = "ajnsdkn";
        url = StringUtils.trimTrailingCharacter(url, '/');
        System.out.println(url);

        System.out.println(ChronoUnit.YEARS.getDuration().multipliedBy(5).toMinutes());
        System.out.println("5 years: " + ((5 * 365 + 1) * 24 * 60));

        System.out.println(HttpStatus.BAD_REQUEST.getReasonPhrase());
        System.out.println(HttpStatus.BAD_REQUEST);
        System.out.println(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }
}
