import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static java.lang.String.join;

public class HashUtil {
    public static void main(String[] args) {
        System.out.println(hashToMD5("PAPA"));
        System.out.println(hashToMD5("КИРИЛЛИЦА", "КИРИЛЛИЦА-", " ЦИФРА10").equals("c37f4937e2509177cb2ddf920a6cc4e8"));
    }

    public static String hashToMD5(String ...strings) {
        return DigestUtils.md5DigestAsHex(join("", strings).getBytes(StandardCharsets.UTF_8));
    }
}
