package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

    static int n;
    static int k;
    static int[] visited = new int[100_001];

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int depth = visited[current];
            if (current - 1 >= 0 && visited[current - 1] == 0) {
                queue.offer(current - 1);
                visited[current - 1] = depth + 1;
                if (current - 1 == k) {
                    System.out.println(visited[current - 1] - 1);
                }
            }
            if (current + 1 < visited.length && visited[current + 1] == 0) {
                queue.offer(current + 1);
                visited[current + 1] = depth + 1;
                if (current + 1 == k) {
                    System.out.println(visited[current + 1] - 1);
                }
            }
            if (current * 2 < visited.length && visited[current * 2] == 0) {
                queue.offer(current * 2);
                visited[current * 2] = depth + 1;
                if (current * 2 == k) {
                    System.out.println(visited[current * 2] - 1);
                }
            }
        }
    }
}
