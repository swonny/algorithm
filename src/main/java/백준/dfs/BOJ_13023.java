package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static int n;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean isAnswer = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            var from = Integer.parseInt(st.nextToken());
            var to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, 1);
                if (isAnswer) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    public static void dfs(int vertex, int depth) {
        if (depth == 5) {
            isAnswer = true;
            return;
        }

        visited[vertex] = true;
        for (var g : graph.get(vertex)) {
            if (!visited[g]) {
                dfs(g, depth + 1);
            }
        }
        visited[vertex] = false;
    }
}
