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
import java.util.stream.Collectors;

public class BOJ_2644_v2 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        List<Integer> dest = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        final int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            List<Integer> tmp = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            map.putIfAbsent(tmp.get(0), new ArrayList<>());
            map.get(tmp.get(0)).add(tmp.get(1));

            map.putIfAbsent(tmp.get(1), new ArrayList<>());
            map.get(tmp.get(1)).add(tmp.get(0));
        }

        System.out.println(bfs(map, dest.get(0), dest.get(1), n));
    }

    public static int bfs(Map<Integer, List<Integer>> map, int src, int dest, int n) {
        int[] visited = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i : map.get(tmp)) {
                if (visited[i] == 0) {
                    queue.add(i);
                    visited[i] = visited[tmp] + 1;
                }
            }
        }

        return visited[dest] > 0 ? visited[dest] : -1;
    }
}
