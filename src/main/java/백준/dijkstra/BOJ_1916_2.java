package 백준.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_2 {

    static int N, M, from, to;
    static Map<Integer, List<Node>> graph = new HashMap<>();
    static boolean[] visited;
    static int[] dist;

    static class Node implements Comparable<Node> {

        int cost;
        int index;

        public Node(int cost, int index) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(st.nextToken());
            final int to = Integer.parseInt(st.nextToken());
            final int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        final StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
        dijkstra();

        System.out.println(dist[to]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(from, 0));
        dist[from] = 0;

        while (!pq.isEmpty()) {
            final Node current = pq.poll();
            if (visited[current.index]) continue;
            if (current.cost > dist[current.index]) continue;

            for (Node next : graph.get(current.index)) {
                if (!visited[next.index] && dist[next.index] > dist[current.index] + next.cost) {
                    dist[next.index] = dist[current.index] + next.cost;
                    pq.offer(new Node(next.index, dist[current.index] + next.cost));
                }
            }
        }
    }
}
