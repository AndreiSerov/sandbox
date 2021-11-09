import org.springframework.beans.factory.annotation.Value;

import java.util.Comparator;
import java.util.List;

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
    @Value("${test}")
    private long someLong = 1_200_000;


    public static void main(String[] args) {

        A1 a1 = new A1();
        a1.setNum(10)
        ;
        List<A1> list = List.of(a1);
        System.out.println(list.stream()
                .max(Comparator.comparing(A1::getNum))
                .orElse(null));


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
