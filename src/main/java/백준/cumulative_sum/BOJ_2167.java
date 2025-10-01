package 백준.cumulative_sum;

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

        int[][] sum = new int[N][M];
        for (int i = 0; i < N; i++) {
            final StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                sum[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int[][] cumSum = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                cumSum[i][j] = cumSum[i - 1][j] + cumSum[i][j - 1] - cumSum[i - 1][j - 1] + sum[i-1][j-1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int n = 0; n < k; n++) {
            final StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st2.nextToken());
            int j = Integer.parseInt(st2.nextToken());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            final int res = cumSum[x][y] - cumSum[x][j - 1] - cumSum[i - 1][y] + cumSum[i - 1][j - 1];
            System.out.println(res);
        }
    }
}
