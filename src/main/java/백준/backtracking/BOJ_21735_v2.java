package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21735_v2 {
    static int n, m;
    static int[] snows;
    static int max;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        snows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, -1, 1);

        System.out.println(max);
    }

    public static void dfs(int depth, int i, int size) {
        if (depth == m || i == n - 1) {
            max = Math.max(max, size);
            return;
        }

        if (i + 1 < n) {
            dfs(depth + 1, i + 1, size + snows[i + 1]);
        }

        if (i + 2 < n) {
            dfs(depth + 1, i + 2, (size / 2) + snows[i + 2]);
        }
    }
}
