import java.util.HashMap;
import java.util.Scanner;

/**
 * @author andreiserov
 */
public class PhoneBook {
    private static final Scanner sc = new Scanner(System.in);

    private static final HashMap<String, String> phones = new HashMap<>();

    static {
        phones.put("Vasya", "89123456789");
    }

    public static void main(String[] args) {
        System.out.println("""


                1 - Add contact""");
        System.out.println("2 - Get contact");
        System.out.println("3 - Show all contacts");

        String choice = sc.nextLine();



        while(!choice.equals("q")) {
            if (choice.equals("1")) {
                System.out.println("Enter the name");
                final String name = sc.nextLine();
                System.out.println("Enter the phone");
                final String phone = sc.nextLine();
                phones.put(name, phone);
                System.out.printf("You added new contact: %s - %s", name, phone);
            } else {
                phones.forEach(
                    (k, v) -> System.out.printf("%s - %s\n", k, v)
                );
            }

            System.out.println("""


                    1 - Add contact""");
            System.out.println("2 - Get contact");
            System.out.println("3 - Show all contacts");
            choice = sc.nextLine();
        }
    }
}
