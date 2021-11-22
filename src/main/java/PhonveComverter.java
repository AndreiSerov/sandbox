public class PhonveComverter {
    static String plusPhone = "+79123456789";
    static String correctPhone = "79123456789";
    static String eightPhone = "89123456789";

    public static String getPhone(String phone) {
        return "00" + phone.replaceAll("\\W", "").replaceFirst("^8", "7");
    }


    public static void main(String[] args) {

        System.out.println(getPhone(plusPhone));
        System.out.println(getPhone(correctPhone));
        System.out.println(getPhone(eightPhone));


    }
}
