package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final int[][] cumulativeSum = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            final String[] strings = br.readLine().split(" ");
            for (int j = 1; j < M + 1; j++) {
                cumulativeSum[i][j] = cumulativeSum[i][j - 1] + Integer.parseInt(strings[j - 1]);
            }
        }

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                cumulativeSum[j][i] = cumulativeSum[j - 1][i] + cumulativeSum[j][i];
            }
        }

        final int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            final StringTokenizer st1 = new StringTokenizer(br.readLine());
            final int i = Integer.parseInt(st1.nextToken());
            final int j = Integer.parseInt(st1.nextToken());
            final int x = Integer.parseInt(st1.nextToken());
            final int y = Integer.parseInt(st1.nextToken());

            final int answer = cumulativeSum[x][y] - cumulativeSum[x][j - 1] - cumulativeSum[i - 1][y] + cumulativeSum[i - 1][j - 1];
            System.out.println(answer);
        }
    }
}
