import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapDiscovery {

    static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("1", List.of("some"));

        System.out.println(map.get("2"));
        String str = "ABCD".substring(0, 3);
        String str2 = "GPB-asd";
        String str3 = "contEnt-type";
        System.out.println(str2.matches("(?i)gpb-.*|^content-type$"));
        System.out.println(str3.matches("(?i)gpb-|^content-type$"));
        System.out.println(str);
//        System.out.println(map.get("2").get(0));

    }
}
