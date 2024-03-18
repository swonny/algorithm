package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16173 {

    static int N;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            for (int i = 0; i < 2; i++) {
                int nx = cx + dx[i] * graph[cy][cx];
                int ny = cy + dy[i] * graph[cy][cx];
                if (isValid(nx, ny)) {
                    if (graph[ny][nx] == -1) {
                        System.out.println("HaruHaru");
                        return;
                    }
                    if (!visited[ny][nx]) {
                        queue.offer(new int[]{nx, ny});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        System.out.println("Hing");
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
