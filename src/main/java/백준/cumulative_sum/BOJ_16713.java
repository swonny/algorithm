package 백준.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16713 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st2.nextToken());
        final int Q = Integer.parseInt(st2.nextToken());
        final String[] strings = br.readLine().split(" ");

        int[] cumSum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cumSum[i] = cumSum[i - 1] ^ Integer.parseInt(strings[i - 1]);
        }

        int result = 0;
        for (int i = 0; i < Q; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int fromIdx = Integer.parseInt(st.nextToken());
            final int endIdx = Integer.parseInt(st.nextToken());
            final int answer = cumSum[endIdx] ^ cumSum[fromIdx - 1];
            result = result ^ answer;
        }

        System.out.println(result);
    }
}
