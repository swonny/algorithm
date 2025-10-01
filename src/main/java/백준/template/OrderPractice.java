package 백준.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderPractice {

    static class Node<T, R> {

        T left;
        R right;

        public T getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }

        public static <T, R> Node<T, R> of(T t, R r) {
            var result = new Node<T, R>();
            result.left = t;
            result.right = r;

            return result;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("first", 1, "second", 2, "third", 3);
        final List<String> collect = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(collect);

        new ArrayList<>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = Arrays.copyOf(a, 3);
        System.out.println(Arrays.toString(b));

        Map<Integer, String> map1 = new HashMap<>();
        final Stream<Map.Entry<Integer, String>> sorted = map1.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()));

        map1.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));
    }
}
