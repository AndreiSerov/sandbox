import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumContains {

    public static void main(String[] args) {
        final Map<String, List<String>> map = new HashMap<>();
        map.put("kalia", List.of("1"));
        map.put("Kalia2", List.of("1"));
        map.put("balia", List.of("1"));

        final Map<String, List<String>> map1 = new HashMap<>();
        map.put("balia", List.of("1"));


//        System.out.println(SomeEnum.contains("kalia")); // true

        System.out.println(SomeEnum.contains(map.keySet())); // false
        System.out.println(SomeEnum.contains(map1.keySet()));


    }
}


enum SomeEnum {
    KALIA("kalia"),
    KALIA2("kalia2");

    private final String value;

    SomeEnum(String s) {
        this.value = s;
    }

    public static boolean contains(@NotNull String value) {
        return Arrays.stream(SomeEnum.values()).anyMatch(item -> item.value.equalsIgnoreCase(value));
    }

    public static boolean contains(@NotNull Collection<String> values) {
        return Arrays.stream(SomeEnum.values())
                .allMatch(it -> values.contains(it.value));
    }
}