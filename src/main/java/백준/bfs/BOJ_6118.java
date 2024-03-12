package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_6118 {

    static int n;
    static int m;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[n + 1];

        graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(ai, new ArrayList<>());
            graph.putIfAbsent(bi, new ArrayList<>());
            graph.get(ai).add(bi);
            graph.get(bi).add(ai);
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;
        int max = 0;

        List<Integer> houses = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int depth = current[1];
            for (int next : graph.get(x)) {
                if (!visited[next]) {
                    queue.offer(new int[]{next, depth + 1});
                    visited[next] = true;
                    if (depth + 1 > max) {
                        houses = new ArrayList<>();
                        houses.add(next);
                        max = depth + 1;
                    } else if (depth + 1 == max) {
                        houses.add(next);
                    }
                }
            }
        }

        final List<Integer> sortedHouses = houses.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedHouses.get(0) + " " + max + " " + sortedHouses.size());
    }
}
