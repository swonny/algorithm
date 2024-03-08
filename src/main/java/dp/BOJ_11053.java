package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11053 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final String[] strings = br.readLine().split(" ");
        final int[] numbers = new int[N];
        final int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            dp[i] = 1;
        }

        int answer = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
