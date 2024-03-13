package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2606 {

    static int n;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        final int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int p = Integer.parseInt(st.nextToken());
            final int c = Integer.parseInt(st.nextToken());
            graph[p][c] = 1;
            graph[c][p] = 1;
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i < n + 1; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
