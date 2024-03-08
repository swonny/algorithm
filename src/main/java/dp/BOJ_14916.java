package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100_000];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i < N; i++) {
            if (i % 5 == 0) {
                dp[i] = i / 5;
            } else if (i % 2 == 0) {
                dp[i] = i / 2;
            } else {
                int mod5 = i % 5;
                int mod = i / 5;
                while (mod5 > 0) {
                    if (mod5 % 2 == 0) {
                        System.out.println("mod * 5 = " + (mod * 5));
                        System.out.println("mod % 5 = " + mod % 5);
                        System.out.println("mod = " + mod);
                        System.out.println("i = " + i);
                        System.out.println();
                        dp[i] = dp[mod * 5] + dp[mod % 5];
                    }
                    mod--;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
