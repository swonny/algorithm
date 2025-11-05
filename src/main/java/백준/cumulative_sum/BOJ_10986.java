package 백준.cumulative_sum;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var m = sc.nextInt();

        long[] sum = new long[n];
        long[] combination = new long[m];
        long answer = 0;

        sum[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int remainder = (int) (sum[i] % m);
            if (remainder == 0) answer++;
            combination[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (combination[i] > 1) {
                answer = answer + (combination[i] * (combination[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
