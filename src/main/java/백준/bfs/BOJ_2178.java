package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int count = 0;
    static boolean[][] visited;
    static char[][] graph;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0, 0));

    }

    public static int bfs(int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            var root = q.poll();
            if (root[0] == n - 1 && root[1] == m - 1) {
                return root[2];
            }

            for (int i = 0; i < 4; i++) {
                var tmpX = root[0] + dx[i];
                var tmpY = root[1] + dy[i];
                if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < m) {
                    if (graph[tmpX][tmpY] == '1' && !visited[tmpX][tmpY]) {
                        q.add(new int[]{tmpX, tmpY, root[2] + 1});
                        visited[tmpX][tmpY] = true;
                    }
                }
            }
        }

        return -1;
    }
}
