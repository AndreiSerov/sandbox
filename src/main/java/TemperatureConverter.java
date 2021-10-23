import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("From which units you want convert: ");
        System.out.println("1 - Celsius, 2 - Fahrenheit");
        int unitCode = scanner.nextInt();
        System.out.println("How much temperature u want to convert");
        long units = scanner.nextLong();

        if (unitCode == 1) {
            System.out.println((units * 9 / 5) + 32);
        } else {
            System.out.println((units - 32) * 5 / 9);
        }
    }
}
