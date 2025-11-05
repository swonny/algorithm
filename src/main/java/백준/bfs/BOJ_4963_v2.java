package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_v2 {
    static int[] xs = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] ys = {-1, 1, 0, 0, -1, 1, 1, -1};

    static boolean[][] visited;
    static int w;
    static int h;

    static class Pair<T, R> {
        T x;
        R y;

        private T getX() {
            return x;
        }

        private R getY() {
            return y;
        }

        public static <T, R> Pair<T, R> of(T t, R r) {
            var result = new Pair<T, R>();
            result.x = t;
            result.y = r;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());
            if (w == 0 && h == 0) break;

            int[][] graph = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        bfs(graph, i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    /**
     * 1. [0, 0] ~ [w, h]까지 돌면서 bfs 탐색
     * 2. 만약 섬이면 bfs 시작 & 방문 처리
     * 3. 돌아오면 ++
     *
     *
     *   xs = {0, 0, -1, 1};
     *   ys = {-1, 1, 0, 0};
     */
    public static void bfs(int[][] graph, int x, int y) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(Pair.of(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            final Pair poll = queue.poll();
            for (int i = 0; i < 8; i++) {
                int tmpX = (int) poll.getX() + xs[i];
                int tmpY = (int) poll.getY() + ys[i];

                if (isWithinInclusive(tmpX, tmpY) && graph[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]) {
                    visited[tmpX][tmpY] = true;
                    queue.offer(Pair.of(tmpX, tmpY));
                }
            }
        }
    }

    private static boolean isWithinInclusive(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}
