package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

    static String[][] graph;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        graph = new String[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().split("");
        }

        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col]) {
                    bfs(row, col, graph[row][col]);
                    count++;
                }
            }
        }
        System.out.print(count + " ");

        count = 0;
        visited = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col]) {
                    if (graph[row][col].equals("R") || graph[row][col].equals("G")) {
                        bfs(row, col, "R", "G");
                    } else {
                        bfs(row, col,"B");
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int r, int c, String... strings) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            final int row = current[0];
            final int col = current[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dy[i];
                int nextCol = col + dx[i];
                if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < n && !visited[nextRow][nextCol]) {
                    for (String string : strings) {
                        if (graph[nextRow][nextCol].equals(string)) {
                            queue.offer(new int[]{nextRow, nextCol});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        }

    }
}
