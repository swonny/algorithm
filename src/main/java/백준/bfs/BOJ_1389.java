package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1389 {

    static int N;
    static int M;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        result = new int[N + 1];
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

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            result[i] = bfs(i);
            min = Math.min(min, result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == min) {
                System.out.println(i);
                return;
            }
        }
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    result[next] = result[current] + 1;
                    visited[next] = true;
                }
            }
        }

        return Arrays.stream(result).sum();
    }
}
