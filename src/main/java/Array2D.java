import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author andreiserov
 */
public class Array2D {

    public static void main(String[] args) {

        basic();

        concat();

        copy();

        iterate2D();

//        multiplicationTable();




    }

    private static void basic() {
        System.out.println("basic");
        // initialization
        char[] chars = new char[10]; // \\u0000
        String[] strings = new String[10];
        char[] chars1 = {'a', 'b', 'c'};
        int[] x = {10};

        // set element
        chars[5] = 'K';


        // indexed loop
        for (int i = 0; i < chars.length; i++) {
            System.out.println(" INdex is" + chars[i] + " but In Pascal " + (i + 1));
        }
        System.out.println();

        Arrays.fill(chars, 'd');
        // foreach loop
        for (char ch : chars) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    static void concat() {
        System.out.println("concat");
        int[] ints = new int[] {5, 3, 1};
        int[] ints1 = {3, 8, 8};
        final int[] concatedInts = concatArrays(ints1, ints);

        System.out.println(Arrays.toString(concatedInts));

        Arrays.sort(concatedInts);
        System.out.println(Arrays.toString(concatedInts));
    }

    static void copy() {
        System.out.println("copy");
        int[][] ints = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][][] int2 = {
            {
                {1, 2, 3},
                {4, 5, 6}
            },
            {
                {7, 8, 9}
            }
        };

        final int[][] intsCopy = Arrays.copyOf(ints, 2);
        printArr(intsCopy);
    }

    static void iterate2D() {
        System.out.println("iterate2D");
        int[][] ints = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


//        for (int[] row : ints) {
//            for (int column : row) {
//                System.out.print((column * 10) + " ");
//            }
//            System.out.println();
//        }

        var intsCopied = copy(ints);
        System.out.println();
    }

    private static int[][] copy(int[][] ints) {
        final int[][] ints1 = {};

        if (ints != null && ints.length == 0) {
            return ints1;
        }

        int[][] res = new int[ints.length][ints[0].length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.println(ints[i][j]);

                res[i][j] = (ints[i][j] % 2 == 0) ? ints[i][j] : 999999;
            }
        }
        return res;
    }

    static void multiplicationTable() {
        System.out.println("multiplicationTable");
        int[][] ints = getMultitable(9);

        print(ints);

    }

    static int[][] getMultitable(int size) {
        int[][] table = new int[size][size];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }

    static <T> T[] concatArrays(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    static int[] concatArrays(int[] array1, int[] array2) {
        int[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    static <T> T concatArraysReflection(T array1, T array2) {
        if (!array1.getClass().isArray() || !array2.getClass().isArray()) {
            throw new IllegalArgumentException("Only arrays are accepted.");
        }

        Class<?> compType1 = array1.getClass().getComponentType();
        Class<?> compType2 = array2.getClass().getComponentType();

        if (!compType1.equals(compType2)) {
            throw new IllegalArgumentException("Two arrays have different types.");
        }

        int len1 = Array.getLength(array1);
        int len2 = Array.getLength(array2);

//        @SuppressWarnings("unchecked")
        T result = (T) Array.newInstance(compType1, len1 + len2);

        System.arraycopy(array1, 0, result, 0, len1);
        System.arraycopy(array2, 0, result, len1, len2);

        return result;
    }

    static void printArr(Object[] a) {
        System.out.println(Arrays.deepToString(a));
    }

    static void print(@NotNull int[][] ints) {
        for (int[] row : ints) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

}


