package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14400 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        long[] x = new long[n];
        long[] y = new long[n];

        for (int i = 0; i < n; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        long midX = x[n / 2];
        long midY = y[n / 2];

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(x[i] - midX) + Math.abs(y[i] - midY);
        }

        System.out.println(res);
    }
}
