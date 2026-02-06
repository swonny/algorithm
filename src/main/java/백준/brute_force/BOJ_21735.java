package 백준.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21735 {
    static int n;
    static int m;
    static int[] snows;
    static int[] perm;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        perm = new int[m + 1];
        perm[0] = 1;
        visited = new boolean[n + 1]; // snow 인덱스

        snows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 0);

        System.out.println(Arrays.toString(perm));
        System.out.println(max);
    }

    public static void dfs(int depth, int i) {
        System.out.println("perm[" + depth + "]: " + perm[depth] + ", i:" + i);
        if (depth == m) {
            max = Math.max(max, perm[depth]);
            return;
        }

        if (i + 1 < n) {
            perm[depth + 1] = perm[depth] + snows[i + 1];
            dfs(depth + 1, i + 1);
        }
        if (i + 2 < n) {
            perm[depth + 1] = (perm[depth] / 2) + snows[i + 2];
            dfs(depth + 1, i + 2);
        }
    }
}
