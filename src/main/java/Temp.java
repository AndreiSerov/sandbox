import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Temp {
    public static void function() {
        List<Integer> numbers = IntStream.rangeClosed(0, 10).boxed().collect(toList());
        Predicate<Integer> integerPredicate = it -> it % 2 == 0;
        List<Integer> evenNumbers = numbers.stream()
                .filter(integerPredicate)
                .collect(toList());
        System.out.println(numbers);
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return obj -> condition.test(obj) ? ifTrue.apply(obj) : ifFalse.apply(obj); // your implementation here
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;

        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength);
//        function();
    }

}
