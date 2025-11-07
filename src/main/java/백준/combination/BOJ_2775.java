package 백준.combination;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_2775 {
    public static void main(String[] args) throws IOException {
        var sc = new Scanner(System.in);
        var t = sc.nextInt();

        int[] n = new int[t] , k = new int[t];
        for (int i = 0; i < t; i++) {
            k[i] = sc.nextInt();
            n[i] = sc.nextInt();
        }

        var dp = new int[15][15];
        for (int i = 0; i <= 14; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(dp[k[i]][n[i]]);
        }
    }
}
