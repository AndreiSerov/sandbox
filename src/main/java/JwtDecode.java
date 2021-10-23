import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class JwtDecode {

    public static void main(String[] args) {
        String stringToDecode = "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ==";
        Map<String, String> payload = decode(stringToDecode);
        String encodedString = encode("{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":1516239022}");
        System.out.println(encodedString.equals(stringToDecode));
        System.out.println(payload);
    }

//    {"sub":"1234567890","name":"John Doe","iat":1516239022}

    @SneakyThrows
    private static Map<String, String> decode(String str) {
        ObjectMapper objectMapper = new ObjectMapper();
        String payload = new String(
                Base64.getUrlDecoder().decode(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8
        );

        return objectMapper.readValue(payload, new TypeReference<>() {});
    }

    @SneakyThrows
    private static String encode(String str) {
        return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }
}
