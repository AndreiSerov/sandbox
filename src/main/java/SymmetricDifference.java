import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        return Stream.concat(set1.stream(), set2.stream())
                .filter (x -> set1.contains(x) != set2.contains(x))
                .collect(Collectors.toSet());
    }



    public static void main(String[] args) {
        System.out.println(symmetricDifference(Set.of(1, 2, 3), Set.of(0, 1, 2)).equals(Set.of(0, 3)));
//        System.out.println(Set.of(0, 3).equals(Set.of(0, 3)));
    }
}
