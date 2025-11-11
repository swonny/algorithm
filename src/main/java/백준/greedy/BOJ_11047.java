package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());

        var coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        var res = 0;
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (coins[i] <= k) {
                res += (k / coins[i]);
                k %= coins[i];
            }
        }
        System.out.println(res);
    }
}
