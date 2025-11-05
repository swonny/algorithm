package 백준.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_11659 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final List<Integer> nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] cumSum = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            cumSum[i] += cumSum[i - 1] + nums.get(i - 1);
        }

        for (int i = 0; i < M; i++) {
            final List<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(cumSum[collect.get(1)] - cumSum[collect.get(0) - 1]);
        }
    }
}
