package 백준.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2118 {
    
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final int[] cumSum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cumSum[i] = cumSum[i - 1] + Integer.parseInt(br.readLine());
        }

        final int total = cumSum[N];

        int answer = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                final int d1 = cumSum[j - 1] - cumSum[i - 1];
                final int d2 = total - d1;
                final int tmp = Math.min(d1, d2);
                answer = Math.max(answer, tmp);
            }
        }

        System.out.println(answer);
    }
}
