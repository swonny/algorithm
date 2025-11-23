package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016_v2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var min = Long.parseLong(st.nextToken());
        var max = Long.parseLong(st.nextToken());

        /**
         * 1보다 큰 제곱수로 나누어 떨어지지 않는 수
         * 1과 자신을 제외한 나머지 수로 나누어 떨어지지 않는 수
         *
         * 1보다 큰 제곱수로 나누어 떨어지지 않는 수 = 1보다 큰 제곱수로 나누어 떨어지는 수를 모두 제외한 수
         *
         * min ~ max는 최대 1,000,000개
         * min ~ max 까지 수 중 제곱수의 배수만 지우면 됨
         * -> 어떻게?
         * 2의 제곱수부터 시작해서 1씩 늘려가면서, min ~ max 사이에 해당하는 제곱수 배수의 최솟값을 구하면 됨
         * 예를 들어
         * 1. 먼저 min ~ max 사이값 중 2의 제곱수인 4의 배수 중 최솟값을 찾는다.
         *    a. min / 4
         *        a.1. min % 4 != 0이라면 제곱수로 나누어 떨어지지 않는 값이다.
         *             따라서 4의 배수 중 최솟값은 (4 * (a + 1))이 된다.
         *             (min % 4 == 0이라면 min이 제곱수로 나누어 떨어지는 수이기 때문에 min ~ max 사이값 중 4의 배수의 최솟값은 min이 된다.)
         *    c. 즉, 4의 배수 중 최솟값은 4 * (a에서 구한 값)이 된다.
         *       이것이 배수를 구하는 식이기 때문이다. 그리고 min ~ max 사이에서 배수를 모두 제거하기 위해 a를 1씩 늘려가면서 max까지의 값을 제거하면 된다.
         *
         */

        var check = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            var pow = i * i;
            var quotient = min / pow;
            if (min % pow != 0) quotient += 1;
            for (long j = quotient; j * pow <= max; j++) {
                check[(int) (j * pow - min)] = true;
            }
        }

        var count = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) count++;
        }

        System.out.println(count);
    }
}
