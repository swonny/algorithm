package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_v3 {
    static boolean[][] graph;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        var v = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            var from = Integer.parseInt(st.nextToken());
            var to = Integer.parseInt(st.nextToken());

            graph[from][to] = true;
            graph[to][from] = true;
        }

        dfs(m);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(m);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int root = q.poll();
            System.out.print(root + " ");
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[root][i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && graph[start][i]) {
                dfs(i);
            }
        }
    }
}
