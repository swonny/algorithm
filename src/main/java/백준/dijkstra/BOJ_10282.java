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

public class BOJ_10282 {

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

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", cost=" + cost +
                    '}';
        }
    }

    static int[] dist;
    static boolean[] visited;
    static int count;
    static Map<Integer, List<Node>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            final int n = Integer.parseInt(stringTokenizer.nextToken());
            final int d = Integer.parseInt(stringTokenizer.nextToken());
            final int c = Integer.parseInt(stringTokenizer.nextToken());
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                final int a = Integer.parseInt(st.nextToken());
                final int b = Integer.parseInt(st.nextToken());
                final int cost = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node(a, cost));
            }
            count = 0;
            final int res = dist[dijkstra(c)];
            System.out.println(count + " " + res);
        }
    }

    public static int dijkstra(int start) {
        int lastIdx = start;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            final Node current = pq.poll();
            if (visited[current.index]) continue;
            lastIdx = current.index;
            count++;
            visited[current.index] = true;
            for (Node next : graph.get(current.index)) {
                if (dist[next.index] > dist[current.index] + next.cost) {
                    dist[next.index] = dist[current.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return lastIdx;
    }
}
