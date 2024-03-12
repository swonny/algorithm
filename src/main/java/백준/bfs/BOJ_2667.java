package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {

    static int[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    final int bfs = bfs(j, i);
                    answer.add(bfs);
                }
            }
        }

        System.out.println(answer.size());
        answer.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static int bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        queue.offer(new int[]{x, y});
        graph[y][x] = 0;
        count++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            final int col = poll[0];
            final int row = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dy[i];
                int nextCol = col + dx[i];
                if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N && graph[nextRow][nextCol] == 1) {
                    queue.offer(new int[]{nextCol, nextRow});
                    graph[nextRow][nextCol] = 0;
                    count++;
                }
            }
        }

        return count;
    }
}
