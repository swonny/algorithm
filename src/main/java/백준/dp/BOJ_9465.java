package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int col = Integer.parseInt(br.readLine());
            int[][] data = new int[2][col + 1];
            for (int j = 0; j < 2; j++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < col + 1; k++) {
                    data[j][k]  = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][col + 1];
            dp[0][1] = data[0][1];
            dp[1][1] = data[1][1];
            for (int j = 2; j < col + 1; j++) {
                dp[0][j] += Math.max(dp[1][j - 1], dp[1][j - 2]) + data[0][j];
                dp[1][j] += Math.max(dp[0][j - 1], dp[0][j - 2]) + data[1][j];
            }
            System.out.println(Math.max(dp[0][col], dp[1][col]));
        }
    }
}
