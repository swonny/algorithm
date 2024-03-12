package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948 {

    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int n;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];

        System.out.println(bfs());
    }

    public static int bfs() {
        int[] dx = {-1, 1, -2, 2, -1, 1};
        int[] dy = {-2, -2, 0, 0, 2, 2};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1, 0});
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int depth = current[2];
            for (int i = 0; i < dx.length; i++) {
                int nextRow = r + dy[i];
                int nextCol = c + dx[i];
                if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && visited[nextRow][nextCol] == false) {
                    if (nextRow == r2 && nextCol == c2) {
                        return depth + 1;
                    }
                    queue.offer(new int[]{nextRow, nextCol, depth + 1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return -1;
    }
}
