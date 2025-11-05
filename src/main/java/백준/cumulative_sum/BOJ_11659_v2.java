package 백준.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_v2 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var n = inputs[0];
        var m = inputs[1];

        var numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var cumSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cumSum[i] = cumSum[i-1] + numbers[i-1];
        }

        for (int i = 0; i < m; i++) {
            var st = new StringTokenizer(br.readLine());
            var from = cumSum[Integer.parseInt(st.nextToken()) - 1];
            var to = cumSum[Integer.parseInt(st.nextToken())];
            System.out.println(to - from);
        }
    }
}
