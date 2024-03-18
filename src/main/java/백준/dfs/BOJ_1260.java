package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_1260 {

    static int N;
    static int M;
    static int from;

    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        from = Integer.parseInt(stringTokenizer.nextToken());

        graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int first = Integer.parseInt(st.nextToken());
            final int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        for (int i = 1; i <= N; i++) {
            graph.put(i, graph.get(i).stream().sorted().collect(Collectors.toUnmodifiableList()));
        }

        visited = new boolean[N + 1];
        dfs(from);
        System.out.println();
        bfs();
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs() {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.print(poll + " ");
            for (int next : graph.get(poll)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
