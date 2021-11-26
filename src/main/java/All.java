import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Map<String, List<String>> map = new HashMap<>();
        map.put("Kalia", List.of("1", "2", "3", "4", "5"));
        map.put("Balia", List.of("1", "2", "3", "4", "5"));
        map.put("content-type", List.of("WRONG"));

        map.put("Other", Collections.emptyList());


        final HttpHeaders headers = new HttpHeaders();

        var kalia = map.entrySet()
                .stream()
                .filter(it -> it.getKey().matches("(?i).*alia|"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        headers.putAll(kalia);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        System.out.println(kalia);
        System.out.println(headers);


        Instant now = Instant.now();
        Instant nullVal = null;

        final Obj objNull = null;
        final Obj obj = new Obj();
        obj.setA("A");

        System.out.println(Optional.ofNullable(obj)
                .filter(it -> !it.getA().equals("A"))
                .orElse(new Obj())
        );


//        final Instant instant = Optional.ofNullable(nullVal)
//                .filter(it -> it != null)
////                .orElse(Instant.MAX)
//                .orElseThrow(Exception::new)
//                ;

//        System.out.println(instant);


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

class Obj {
    String a;
    String b;

    public Obj() {
    }

    public String getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
