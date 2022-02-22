import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class A1 {
    private String a;
    private int num;

    public int getNum() {
        return num;
    }

    public A1(String a, int num) {
        this.a = a;
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A1() {
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
                ", num=" + num +
                '}';
    }
}


public class All {

    public static void main(String[] args) throws Exception {
        Instant pastDate = LocalDateTime
                .parse("10-12-2018 00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
                .toInstant(ZoneOffset.UTC);

        System.out.println(pastDate);
//        final List<A1> list = List.of(
//                new A1("1", 1),
//                new A1("2", 2),
//                new A1("3", 3)
//        );
//
//        final A1 a1 = list.stream()
//                .max(Comparator.comparing(A1::getNum))
//                .orElse(null);
//
//        final List<A1> list2 = List.of(new A1("3", 3));
//
//        final A1 a2 = list2.stream()
//                .max(Comparator.comparing(A1::getNum))
//                .orElse(null);
//        System.out.println(a1);

        final long val = Long.parseLong("2592000000");
        System.out.println(val);


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
