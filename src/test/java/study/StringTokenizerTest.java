package study;

import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTokenizerTest {

    @Test
    void StringTokenizer의_nextToken_메서드에_새로운_delimiter를_전달하는_경우_새로운_demilimiter기준으로_구분한다() {
        // given
        StringTokenizer st = new StringTokenizer("공백 기준 : 토큰 생성");

        // when & then
        assertThat(st.nextToken()).isEqualTo("공백");

        final String actual = st.nextToken(":");
        assertThat(actual).isEqualTo(" 기준 ");
    }

    @Test
    void nextToken_메서드는_subString을_사용한다() {
        // given
        StringTokenizer st = new StringTokenizer("공백 기준 토큰 생성");

        // when
        st.nextToken();

        // then
        assertThat(st.nextToken()).isEqualTo("기준");
    }
}
