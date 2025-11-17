package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_v2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var m = Integer.parseInt(st.nextToken());
        var n = Integer.parseInt(st.nextToken());

        var primes = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= n; j += i) {
                primes[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (primes[i] != 0) {
                System.out.println(primes[i]);
            }
        }
    }
}
