package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(new StringBuilder(), n, m);
        System.out.println(answer);
    }

    public static void dfs(StringBuilder arr, int n, int m) {
        if (arr.length() == m * 2) {
            answer.append(arr + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr.append(i + " ");
            dfs(arr, n, m);
            arr.delete(arr.length() - 2, arr.length());
        }
    }
}
