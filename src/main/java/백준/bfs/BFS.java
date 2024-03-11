package 백준.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        int n = 8;
        int[][] graph = {
                {},
                {2, 8, 3},
                {1, 6, 8},
                {1, 5},
                {7, 5},
                {3, 4, 7},
                {2},
                {4, 5},
                {2, 1}
        };

        boolean[] visited = new boolean[n + 1];
        final String result = bfs(graph, 1, visited);

        System.out.println(result);
    }

    public static String bfs(int[][] graph, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node + " ");
            for (int n : graph[node]) {
                if (!visited[n]) {
                    q.offer(n);
                    visited[n] = true;
                }
            }
        }

        return sb.toString();
    }
}
