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

public class BOJ_1753 {

    static Map<Integer, List<Node>> graph;
    static int v, e, start;
    static int[] dist;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(final int index, final int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        v = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new int[v + 1];
        visited = new boolean[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new HashMap<>();
        for (int i = 1; i <= e + 1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            final int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            final Node current = pq.poll();
            if (visited[current.index]) continue;

            visited[current.index] = true;
            for (Node next : graph.get(current.index)) {
                if (dist[next.index] > dist[current.index] + next.cost) {
                    dist[next.index] = dist[current.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
}
