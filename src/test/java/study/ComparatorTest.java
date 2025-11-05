package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComparatorTest {

    @Test
    void Map을__정렬한다() {
        Map<String, Integer> map = new HashMap<>();
        map.entrySet()
           .stream()
           .sorted(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder()).thenComparing(Map.Entry.comparingByKey(Collections.reverseOrder())))
           .map(Map.Entry::getKey)
           .collect(Collectors.toList());

        int[] arr = {1, 2, 3, 4};
        Arrays.sort(arr);
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        String str = "hello world";
        char[] charArray = str.toCharArray();
        System.out.println(Arrays.toString(charArray));

        Arrays.copyOfRange(arr, 1, 3);

        List<Person> people = new ArrayList<>();
        people.add(new Person("a", 1));
        people.add(new Person("b", 2));

        people.stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        people.stream().collect(Collectors.toMap(p -> p, p -> 1, Integer::sum));


        Arrays.stream(arr).min().getAsInt();

        Collections.addAll(list);
        Arrays.stream(arr).sum();

        new StringBuilder().reverse().toString();
    }

    @Test
    void Comparator를_사용해_정수를_비교한다() {
        // given
        int[][] actual = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Arrays.sort(actual, Comparator.comparingInt(row -> row[0]));
    }

    @Test
    void 문자열을_비교한다() {
        // given
        String[][] actual = {
                {"a", "b"},
                {"c", "d"}
        };

        Arrays.sort(actual, Comparator.comparing(row -> row[0]));
    }

    class Person {

        private final String name;
        private final int age;

        Person(final String name, final int age) {
            this.name = name;
            this.age = age;
        }

        private String getName() {
            return name;
        }

        private int getAge() {
            return age;
        }
    }
}
