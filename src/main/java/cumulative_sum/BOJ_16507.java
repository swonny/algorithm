package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16507 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st1 = new StringTokenizer(br.readLine());
        final int R = Integer.parseInt(st1.nextToken());
        final int C = Integer.parseInt(st1.nextToken());
        final int Q = Integer.parseInt(st1.nextToken());

        int[][] cumulativeSum = new int[R + 1][C + 1];
        for (int i = 1; i < R + 1; i++) {
            final String[] strings = br.readLine().split(" ");
            cumulativeSum[i][1] = Integer.parseInt(strings[0]);
            for (int j = 2; j < C + 1; j++) {
                cumulativeSum[i][j] = cumulativeSum[i][j - 1] + Integer.parseInt(strings[j - 1]);
            }
        }

        for (int i = 1; i < C + 1; i++) {
            for (int j = 2; j < R + 1; j++) {
                cumulativeSum[j][i] += cumulativeSum[j - 1][i];
            }
        }

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int r1 = Integer.parseInt(st.nextToken());
            final int c1 = Integer.parseInt(st.nextToken());
            final int r2 = Integer.parseInt(st.nextToken());
            final int c2 = Integer.parseInt(st.nextToken());
            int count = (c2 - c1 + 1) * (r2 - r1 + 1);
            result.append((cumulativeSum[r2][c2] - cumulativeSum[r2][c1 - 1] - cumulativeSum[r1 - 1][c2] + cumulativeSum[r1 - 1][c1 - 1]) / count + "\n");
        }

        System.out.println(result);
    }
}
