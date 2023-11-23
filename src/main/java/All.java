import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

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

interface Recursive<T extends Recursive<T>> {

    @SuppressWarnings("unchecked")
    default T method() {
        System.out.println("Recursive " + this.getClass());
        return (T) this;
    }
}

abstract class AbstractRecursive<T extends AbstractRecursive<T>> implements Recursive<T> {
    @SuppressWarnings("unchecked")
    public T methodFromAbstractClass() {
        System.out.println("AbstractRecursive " + this.getClass());
        return (T) this;
    }
}

class RecursiveImpl extends AbstractRecursive<RecursiveImpl> {

    public RecursiveImpl anotherMethod() {
        System.out.println("Impl " + this.getClass());
        return this;
    }
}

class RecursiveDemo {
    public static void main(String[] args) {

        final RecursiveImpl recursive = new RecursiveImpl();

        recursive.method().methodFromAbstractClass().anotherMethod().method();
        recursive.method().methodFromAbstractClass().anotherMethod();
    }
}

/*
  Нужно написать свой рекуррентный дженерик наподобие того,
  что в классе Стримов
*/

class Main {
    public static void main(String[] args) {

        final GenericImpl generic = new GenericImpl();

        generic
                .method()
                .abstractGenericMethod()
                .method();

        new Page()
                .pushLike()
                .pushMenu()
                .pushHome();
        // generic.method().methodFromAbstractClass().anotherMethod().anotherMethod().method();
    }


}

interface Generic<T extends Generic<T>> {
    default T method() {
        System.out.println("Generic called method: " + this.getClass());
        return (T) this;
    }
}

abstract class AbstractGeneric<T extends AbstractGeneric<T>> implements Generic<T> {
    public T abstractGenericMethod() {
        System.out.println("AbstractGeneric called genericImplMethod: " + this.getClass());
        return (T) this;
    }
}

class GenericImpl extends AbstractGeneric<GenericImpl> {

}

interface NavBar<T extends NavBar<T>> {
    default T pushMenu() {
        return (T) this;
    }
}

interface MenuBar<T extends MenuBar<T>> {
    default T pushHome() {
        return (T) this;
    }
}

abstract class AbstractPage<T extends AbstractPage<T>> implements MenuBar<T>, NavBar<T> {}

class Page extends AbstractPage<Page> {

    public Page pushLike() {
        return this;
    }
}