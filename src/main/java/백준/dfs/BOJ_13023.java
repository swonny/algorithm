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
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int n;
    static boolean hasAnswer = false;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            var from = Integer.parseInt(st.nextToken());
            var to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        System.out.println(graph);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                if (count == 5) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(count != 5 ? 0 : 1);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int g : graph.get(start)) {
            if (!visited[g]) {
                count++;
                dfs(g);
            }
        }
    }
}
