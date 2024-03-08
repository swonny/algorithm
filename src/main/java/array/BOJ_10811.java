package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_10811 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int[] numbers = IntStream.range(1, N + 1).toArray();

        for (int i = 0; i < M; i++) {
            final StringTokenizer st1 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st1.nextToken()) - 1;
            int end = Integer.parseInt(st1.nextToken()) - 1;
            while (from < end) {
                int tmp = numbers[from];
                numbers[from] = numbers[end];
                numbers[end] = tmp;
                end--;
                from++;
            }
        }

        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    }
}
