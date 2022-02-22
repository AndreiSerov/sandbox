import java.util.function.Predicate;

public class GetProps {

    Predicate<String> pr = it -> it.equals("123");


    public static void main(String[] args) {
//        System.setProperty("jdk.attach.allowAttachSelf", String.valueOf(true));
        System.out.println(System.getProperty("jdk.attach.allowAttachSelf"));
    }
}
