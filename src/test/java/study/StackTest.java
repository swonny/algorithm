package study;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest {

    @Nested
    class peek_메서드_사용시 {

        @Test
        void 마지막_원소가_출력된다() {
            // given
            final Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(5);

            // when
            final int lastNumber = stack.peek();

            // then
            assertThat(lastNumber).isEqualTo(5);
        }

        @Test
        void 마지막_원소가_삭제되지_않는다() {
            // given
            final Stack<Integer> stack = new Stack<>();
            stack.push(1);

            // when
            stack.peek();

            // then
            assertThat(stack.size()).isEqualTo(1);
        }
    }
}
