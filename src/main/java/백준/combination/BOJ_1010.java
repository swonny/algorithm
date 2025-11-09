package 백준.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var t = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][31];
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 1; i < 31; i++) {
            for (int j = 1; j < 31; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < t; i++) {
            var st = new StringTokenizer(br.readLine());

            var n = Integer.parseInt(st.nextToken());
            var m = Integer.parseInt(st.nextToken());

            System.out.println(dp[m][n]);
        }
    }
}
