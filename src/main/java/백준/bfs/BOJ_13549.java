package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    static int n;
    static int k;
    static int[] visited = new int[100_001];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        Arrays.fill(visited, Integer.MAX_VALUE);

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        visited[n] = 0;

        while (!queue.isEmpty()) {
            final int[] poll = queue.poll();
            final int x = poll[0];
            final int depth = poll[1];

            if (x + 1 <= 100_000 && visited[x + 1] > depth + 1) {
                queue.offer(new int[]{x + 1, depth + 1});
                visited[x + 1] = depth + 1;
            }
            if (x - 1 >= 0 && visited[x - 1] > depth + 1) {
                queue.offer(new int[]{x - 1, depth + 1});
                visited[x - 1] = depth + 1;
            }
            if (x * 2 <= 100_000 && visited[x * 2] > depth) {
                queue.offer(new int[]{x * 2, depth});
                visited[x * 2] = depth;
            }
        }

        return visited[k];
    }
}
