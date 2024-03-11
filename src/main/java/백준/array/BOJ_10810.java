package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_10810 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        final int[] balls = new int[N];
        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(st.nextToken()) - 1;
            final int end = Integer.parseInt(st.nextToken()) - 1;
            final int num = Integer.parseInt(st.nextToken());
            for (int j = from; j <= end; j++) {
                balls[j] = num;
            }
        }

        System.out.println(Arrays.stream(balls).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
