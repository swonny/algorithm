package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19951 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        final String[] strings = br.readLine().split(" ");

        final int[] cumulativeSum = new int[N + 1];
        for (int i = 0; i < M; i++) {
            final StringTokenizer st1 = new StringTokenizer(br.readLine());
            int fromIdx = Integer.parseInt(st1.nextToken()) - 1;
            int endIdx = Integer.parseInt(st1.nextToken()) - 1;
            int offset = Integer.parseInt(st1.nextToken());
            cumulativeSum[fromIdx] += offset;
            cumulativeSum[endIdx + 1] += -offset;
        }

        for (int i = 1; i < N; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + cumulativeSum[i];
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(Integer.parseInt(strings[i]) + cumulativeSum[i] + " ");
        }

        System.out.println(result);
    }
}
