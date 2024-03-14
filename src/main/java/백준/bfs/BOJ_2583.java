package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_2583 {

    static int m;
    static int n;
    static int k;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[m][n];
        int[][] tmp = new int[m][n];
        for (int i = 0; i < k; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                Arrays.fill(tmp[j], x1, x2, 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[m - 1 - i][j] = tmp[i][j];
            }
        }

        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    count++;
                    answer.add(bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(answer.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;

        queue.offer(new int[]{row, col});
        graph[row][col] = 1;
        count++;

        while (!queue.isEmpty()) {
            final int[] poll = queue.poll();
            final int r = poll[0];
            final int c = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = r + dy[i];
                int nextCol = c + dx[i];
                if (isValid(nextRow, nextCol) && graph[nextRow][nextCol] == 0) {
                    queue.offer(new int[]{nextRow, nextCol});
                    graph[nextRow][nextCol] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValid(int nextRow, int nextCol) {
        return 0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n;
    }
}
