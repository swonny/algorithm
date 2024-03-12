package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {

    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < k; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int row = Integer.parseInt(st.nextToken()) - 1;
            final int col = Integer.parseInt(st.nextToken()) - 1;
            graph[row][col] = 1;
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;

        queue.offer(new int[]{row, col});
        graph[row][col] = 0;
        count++;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            final int r = current[0];
            final int c = current[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = r + dy[i];
                int nextCol = c + dx[i];
                if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < m && graph[nextRow][nextCol] == 1) {
                    queue.offer(new int[]{nextRow, nextCol});
                    graph[nextRow][nextCol] = 0;
                    count++;
                }
            }
        }

        return count;
    }
}
