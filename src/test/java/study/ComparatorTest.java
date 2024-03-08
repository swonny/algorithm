package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

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
    }
}
