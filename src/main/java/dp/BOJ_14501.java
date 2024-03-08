package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] t = new int[1000];
        int[] p = new int[1000];
        for (int i = 1; i < N + 1; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1000];
        for (int i = N; i > 0; i--) {
            if (i + t[i] <= N + 1) {
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
