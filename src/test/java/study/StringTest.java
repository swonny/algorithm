package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void Arrays를_사용해_배열을_출력할수있다() {
        // given
        int[] numbers = {1, 2, 3};

        // when & then
        System.out.println(Arrays.toString(numbers));
    }

    @Test
    void 배열을_내림차순으로_정렬한다() {
        // given
        Integer[] actual = {1, 2, 3, 4};

        // when
        Arrays.sort(actual, Collections.reverseOrder());

        Integer[] expected = {4, 3, 2, 1};

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
