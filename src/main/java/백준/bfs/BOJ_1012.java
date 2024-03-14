package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stringTokenizer.nextToken());
            n = Integer.parseInt(stringTokenizer.nextToken());
            graph = new int[n][m];
            int K = Integer.parseInt(stringTokenizer.nextToken());

            for (int k = 0; k < K; k++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                final int x = Integer.parseInt(st.nextToken());
                final int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void bfs(int row, int col) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});
        graph[row][col] = 0;

        while (!queue.isEmpty()) {
            final int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = r + dy[i];
                int nextCol = c + dx[i];
                if (isValid(nextRow, nextCol) && graph[nextRow][nextCol] == 1) {
                    queue.offer(new int[]{nextRow, nextCol});
                    graph[nextRow][nextCol] = 0;
                }
            }
        }
    }

    private static boolean isValid(int nextRow, int nextCol) {
        return 0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < m;
    }
}
