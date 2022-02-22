import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author andreiserov
 */
public class FibonacciTest {

    Fibonacci sut = new Fibonacci();

    @Test
    void tmp() {
        final int num = sut.get(10);
        assertEquals(0, sut.get(0));
        assertEquals(1, sut.get(1));
        assertEquals(1, sut.get(2));
        assertEquals(2, sut.get(3));
        assertEquals(3, sut.get(4));
        assertEquals(5, sut.get(5));
        assertEquals(8, sut.get(6));
        assertEquals(8, sut.get(70));
    }
}

class Fibonacci {


    public int get(int i) {
        new BigInteger(String.valueOf(10));

        Arrays.stream(getStream().limit(5).toArray(Integer[]::new)).toList();

        final Integer reduce = getStream()
                .limit(10)
                .reduce(0,
                        Integer::sum);

        final Integer[] objects = getStream().limit(5).toArray(Integer[]::new);
        return getStream()
                .skip(i)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    public Stream<Integer> getStream() {
        return Stream.iterate(
                        new Integer[]{0, 1},
                        fib -> new Integer[]{fib[1], fib[0] + fib[1]})
                .map(it -> it[0]);
    }

//    void tmp(List<String> list) {
//
//        list.stream()
////                .i
//    }
}