package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BOJ_1167 {
    static Map<Integer, List<Node>> graph = new HashMap<>();
    static boolean[] visited;
    static int v;
    static int[] distance;

    /**
     * 1. 임의의 노드에서 가장 먼 노드의 인덱스 구하기
     * 2. 1번에서 구한 인덱스의 노드에서 가장 먼 노드와의 거리 구하기
     *
     * 거리 구하기:
     *  1. 큐에 시작점 넣기
     *  2. 큐가 빈값이 아닐 때까지 반복문
     *  3. 큐의 첫 번째 요소를 꺼냄
     *  4. 3번에서 꺼낸 요소가 방문하지 않은 노드라면 큐에 넣음,
     *      4.1 인접 노드까지의 거리를 업데이트함 (루트노드까지의 거리 + 인접 노드까지의 거리)
     *      4.2 방문 처리
     *
     * */
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        visited = new boolean[v + 1];
        distance = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            var tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < tmp.length; j += 2) {
                if (tmp[j] == -1) break;
                graph.get(tmp[0]).add(new Node(tmp[j], tmp[j + 1]));
            }
        }

        bfs(4);
        int maxNode = 1;
        for (int i = 2; i <= v; i++) {
            if (distance[maxNode] < distance[i]) maxNode = i;
        }
        Arrays.fill(distance, 0);
        Arrays.fill(visited, false);
        bfs(maxNode);

        System.out.println(Arrays.stream(distance).max().getAsInt());
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            var root = q.poll();
            for (Node near : graph.get(root)) {
                if (!visited[near.getVertex()]) {
                    q.add(near.getVertex());
                    distance[near.getVertex()] = distance[root] + near.getDistance();
                    visited[near.getVertex()] = true;
                }
            }
        }
    }

    public static class Node {
        int vertex;
        int distance;

        private Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        private int getVertex() {
            return vertex;
        }

        private int getDistance() {
            return distance;
        }

        public String toString() {
            return "vertex: " + vertex + " distance: " + distance + "\n";
        }
    }
}
