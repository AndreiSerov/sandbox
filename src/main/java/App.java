import java.util.Arrays;

class App {
    public static void set(int[] arr, int index, int value) {
        if (index < arr.length) {
            arr[index] = value;
        }
    }

    public static String[] addPrefix(String[] arr, String prefix) {
        return Arrays.stream(arr)
                .map(it -> prefix + " " + it)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] names = {"John", "Smit", "Karl"};
        String[] namesWithPrefix = App.addPrefix(names, "Mr");

        System.out.println(Arrays.toString(namesWithPrefix));

    }
}