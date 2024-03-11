package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2644 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int s = Integer.parseInt(stringTokenizer.nextToken());
        final int e = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int parent = Integer.parseInt(st.nextToken());
            final int child = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(parent, new ArrayList<>());
            graph.putIfAbsent(child, new ArrayList<>());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        final int[] distance = new int[n + 1];
        final int result = bfs(graph, distance, s, e);
        System.out.println(result > 0 ? result : -1);
    }

    public static int bfs(Map<Integer, List<Integer>> graph, int[] distance, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            final int current = queue.poll();
            for (int next : graph.get(current)) {
                if (distance[next] == 0) {
                    queue.offer(next);
                    distance[next] = distance[current] + 1;
                    if (next == end) {
                        return distance[next];
                    }
                }
            }
        }

        return distance[end];
    }
}
