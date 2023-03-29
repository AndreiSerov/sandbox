import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyArray {

    public static void main(String[] args) {
//        String[]  items = {"Table", "Chair", "Bed"};
//        String[] reversed = MyArray.reverse(items);
        final Map<String, Object> map = new HashMap<>();
        map.put("C", "123");
        map.put("B", "123");
        map.put("A", "123");
        map.put("D", "123");


        Set<String> set = new HashSet<>();
//        System.out.println(Arrays.toString(reversed)); // => ["Bed", "Chair", "Table"]
    }

    private void stream() {

    }

    private static String[] reverse(String[] items) {
        final String[] res = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            res[i] = items[items.length - i - 1];
        }
        return res;
    }
}
