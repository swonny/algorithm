package 백준.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_v2 {
    static int n;
    static boolean[] visited;
    static int[] permutation;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        permutation = new int[n];

        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(permutation[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
