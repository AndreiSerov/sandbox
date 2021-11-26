import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumContains {

    public static void main(String[] args) {
        final Map<String, List<String>> map = new HashMap<>();
        map.put("kalia", List.of("1"));
        map.put("balia", List.of("1"));

        final Map<String, List<String>> map1 = new HashMap<>();
        map.put("balia", List.of("1"));


        System.out.println(SomeEnum.contains("kalia"));

        System.out.println(SomeEnum.contains(map.keySet()));
        System.out.println(SomeEnum.contains(map1.keySet()));


    }
}


enum SomeEnum {
    KALIA("kalia");

    private final String value;

    SomeEnum(String s) {
        this.value = s;
    }

    public static boolean contains(@NotNull String value) {
        return Arrays.stream(SomeEnum.values()).anyMatch(item -> item.value.equalsIgnoreCase(value));
    }

    public static boolean contains(@NotNull Collection<String> values) {
        return values.stream().anyMatch(SomeEnum::contains);
    }
}