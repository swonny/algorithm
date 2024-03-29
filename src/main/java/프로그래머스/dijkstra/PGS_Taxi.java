package 프로그래머스.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 합승 택시 요금
 */
public class PGS_Taxi {
    int[] dist;
    boolean[] visited;
    Map<Integer, List<Node>> graph = new HashMap<>();
    int N;

    class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Node={" + "index= " + index + ", " + "cost= " + cost + "}";
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        N = n;
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] f : fares) {
            graph.get(f[0]).add(new Node(f[1], f[2]));
            graph.get(f[1]).add(new Node(f[0], f[2]));
        }

        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, dijkstra(s, k) + dijkstra(k, a) + dijkstra(k, b));
        }

        return answer;
    }

    public int dijkstra(int from, int to) {
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(from, 0));
        dist[from] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.index] || current.cost > dist[current.index]) continue;
            if (current.index == to) {
                return dist[to];
            }

            visited[current.index] = true;
            for (Node next : graph.get(current.index)) {
                if (dist[next.index] > dist[current.index] + next.cost) {
                    dist[next.index] = dist[current.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[to];
    }

}
