package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24482 {

    static int N, M, from;
    static Map<Integer, List<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        from = Integer.parseInt(stringTokenizer.nextToken());
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        graph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        dfs(from, 0);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int from, int depth) {
        visited[from] = depth;

        for (int next : graph.get(from)) {
            if (visited[next] == -1) {
                dfs(next, depth + 1);
            }
        }
    }
}
