package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1929 {
    static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        var m = Integer.parseInt(st.nextToken());
        var n = Integer.parseInt(st.nextToken());

        numbers = new boolean[n + 1];
        Arrays.fill(numbers, true);
        numbers[0] = false;
        numbers[1] = false;

        prime(n);

        var sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (numbers[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void prime(int end) {
        for (int i = 2; i <= end; i++) {
            for (int j = 2; i * j <= end; j++) {
                numbers[i * j] = false;
            }
        }
    }
}
