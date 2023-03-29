//import org.junit.jupiter.api.Test;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * @author andreiserov
// */
//public class MaskPhone {
//
//    String expectedPhoneNumber = "+7 (900) XXX-XX-67";
//    String expectBelarus = "+375 (295) XXX569";
//
//    @Test
//    void getMaskPhoneNumberWhereNumberHaveOnlyDigit() {
////        final var expectedPhoneNumber = null;
//
////        var actual = maskPhoneNumber("79001234567");
////        assertEquals(expectedPhoneNumber, actual);
//    }
//
//    @Test
//    void getMaskPhoneNumberWhereNumberHaveWithSpace() {
//        var actual = maskPhoneNumber("+7 900 123 4567");
//        assertEquals(expectedPhoneNumber, actual);
//    }
//
//    @Test
//    void getMaskPhoneNumberWhereNumberHaveAnotherSymbols() {
//        var actual = maskPhoneNumber("+7(900)-123-45-67");
//        assertEquals(expectedPhoneNumber, actual);
//    }
//
//    @Test
//    void whenBelarusTehnMask() {
//        var actual = maskPhoneNumber("+375295481569");
//        assertEquals(expectBelarus, actual);
//    }
//
//
//
//    public static String maskPhoneNumber(String phone) {
//        String masked = phone.replaceAll("(?<=\\d)\\D+", "")
//                .replaceAll("(?<=\\d{4})\\d(?=\\d{2})", "X");
//
//        int numberLength = masked.toCharArray().length;
//
//        if (phone.charAt(0) == '+') {
//            return "+7 (" + masked.substring(2,5) + ") " + "XXX-XX-" + masked.substring(numberLength - 2,numberLength);
//        }
//        return "+7 (" + masked.substring(1,4) + ") " + "XXX-XX-" + masked.substring(numberLength - 2,numberLength);
//    }
//
//
//}
