package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {

    static int[][] graph;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken()); // 행 크기
        m = Integer.parseInt(stringTokenizer.nextToken()); // 열 크기

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    max = Math.max(max, bfs(j, i));
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static int bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        graph[y][x] = 0;

        int count = 1;
        while (!queue.isEmpty()) {
            int curX = queue.poll();
            int curY = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
                    if (graph[nextY][nextX] == 1) {
                        queue.offer(nextX);
                        queue.offer(nextY);
                        graph[nextY][nextX] = 0;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
