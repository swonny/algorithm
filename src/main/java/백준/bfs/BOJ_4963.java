package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

    static int w;
    static int h;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());
            if (w == 0 && h == 0) break;

            graph = new int[h][w];
            for (int i = 0; i < h; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int y, int x) {
        int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(y);
        queue.offer(x);
        graph[y][x] = 0;

        while (!queue.isEmpty()) {
            final int curY = queue.poll();
            final int curX = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (0 <= nextY && nextY < h && 0 <= nextX && nextX < w) {
                    int nextNode = graph[nextY][nextX];
                    if (nextNode == 1) {
                        queue.offer(nextY);
                        queue.offer(nextX);
                        graph[nextY][nextX] = 0;
                    }
                }
            }
        }
    }
}
