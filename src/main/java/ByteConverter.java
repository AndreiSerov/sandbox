import lombok.Data;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.RequestEntity;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Data
class R2 {
    private String a;
    private String b;
}
public class ByteConverter {

    @SneakyThrows
    public static void main(String[] args) {
        R2 r2 = new R2();
        r2.setA("a");
        r2.setB("b");

//        R2 r21 = r2;
//        r21.setA("Changed");



//        String someStr = "AAA";
//        byte[] bytes = someStr.getBytes(StandardCharsets.UTF_8);
//        String byteString = Arrays.toString(bytes);
////        ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);
////        InputStream inputStream = new InputStream();
//
//        String cook = "cid=ogZdxAVx; _ga=GA1.2...";
//
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://google.com")
//                .build();
//
//        request.headers().newBuilder()
//                .add("cookie", cook);
//
//        String hexString = "0x81ea";
////        byte[] bytes = Hex.decodeHex(hexString.toCharArray());
//
//        Call call = client.newCall(request);
//        Response response = call.execute();
//
//
////        Headers.Builder cookie = Request.Builder.headers().newBuilder().add("cookie", cook);
//
//
////        request.headers().newBuilder()
//        InputStream targetStream = new ByteArrayInputStream(byteString.getBytes());
//        byte[] bytes1 = targetStream.readAllBytes();
//        System.out.println(byteString);
    }
}
