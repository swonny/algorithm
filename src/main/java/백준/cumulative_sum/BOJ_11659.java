package 백준.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final String[] strings = br.readLine()
                .split(" ");

        final int[] prefixSum = new int[N];
        prefixSum[0] = Integer.parseInt(strings[0]);
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(strings[i]);
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken()) - 2;
            int end = Integer.parseInt(st1.nextToken()) - 1;

            int startNumber = start >= 0 ? prefixSum[start] : 0;
            int endNumber = prefixSum[end];
            System.out.println(endNumber - startNumber);
        }

    }
}
