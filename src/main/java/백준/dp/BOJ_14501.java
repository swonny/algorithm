package 백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] t = new int[N + 1];
        int[] p = new int[N + 1];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[N] = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (i + t[i] > N) dp[i] = dp[i + 1];
            else dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]);
        }

        System.out.println(dp[0]);
    }
}
