import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UrlConverter {
    private static String getTime() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss Z")
                .withZone(ZoneId.systemDefault());

        return DATE_TIME_FORMATTER.format(Instant.now());
    }

    public static void main(String[] args) {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("timestamp", getTime());
        paramMap.add("timestamp", getTime() + "_2");
        paramMap.add("timestamp_2", getTime());
        paramMap.add("timestamp_3", getTime());
        String url = "https://some.url/";

        MultiValueMap<String, String> encodedValueMap = new LinkedMultiValueMap<>();
        paramMap.forEach((k, l) -> {
            List<String> encodedValueList = new ArrayList<>();
            l.forEach(v -> encodedValueList.add(URLEncoder.encode(v, StandardCharsets.UTF_8)));
            encodedValueMap.put(k, encodedValueList);
        });

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(encodedValueMap)
                .build(true)
                .toUri();
        System.out.println(uri);
        System.out.println(UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(encodedValueMap)
                .build(true)
        );
    }

}
