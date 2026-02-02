package 백준.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class BOJ_10974 {
    static Set<String> results = new LinkedHashSet<>();
    static int n;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            dfs(String.valueOf(i), 0);
        }

        for (String r : results) {
            System.out.println(r);
        }
    }

    public static void dfs(String string, int depth) {
        if (!results.contains(string) && depth == n - 1) {
            results.add(string);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!string.contains(String.valueOf(i))) {
                dfs(string + " " + i, depth + 1);
            }
        }
    }
}
