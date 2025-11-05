package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        int[] prime = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            dfs(String.valueOf(prime[i]), 1, n);
        }
        System.out.println(sb.toString());
    }

    public static void dfs(String number, int depth, int n) {
        if (depth == n && isPrime(number)) {
            sb.append(number + "\n");
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrime(number + i)) {
                dfs(number + i, depth + 1, n);
            }
        }
    }

    public static boolean isPrime(String number) {
        var n = Integer.parseInt(number);
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
