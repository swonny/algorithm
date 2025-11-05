package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_11724_v2 {
    static int count = 0;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph = new HashMap<>();;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        visited = new boolean[n +1];

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            var from = Integer.parseInt(st.nextToken());
            var to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int g : graph.get(start)) {
            if (!visited[g]) {
                dfs(g);
            }
        }
    }
}
