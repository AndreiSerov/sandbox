import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

class A1 {
    private String a;
    private String b;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A1() {
    }

    public A1(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A1{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", num=" + num +
                '}';
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}


public class All {
    public static void main(String[] args) throws Exception {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("Kalia", Collections.emptyList());
        map.put("Other", Collections.emptyList());


        var kalia = map.entrySet()
                .stream()
                .filter(it -> it.getKey().matches("(?i)^kalia"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(kalia);


        Instant now = Instant.now();
        Instant nullVal = null;

        final Instant instant = Optional.ofNullable(nullVal)
                .orElse(Instant.MAX)
//                .orElseThrow(Exception::new)
                ;

        System.out.println(instant);


//        A1 a1 = new A1();
//        a1.setNum(10)
//        ;
//        List<A1> list = List.of(a1);
//        System.out.println(list.stream()
//                .max(Comparator.comparing(A1::getNum))
//                .orElse(null));


//        All all = new All();
//        System.out.println(all.someLong);
//        A1 a = new A1();
//
//        if (a.getA() != null && a.getA().equalsIgnoreCase("a1")) {
//            System.out.println(a.getA());
//        }

//        String nullStr = null;
//        nullStr.equals("tratata");
    }
}
