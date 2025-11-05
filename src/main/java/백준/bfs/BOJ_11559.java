package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BOJ_11559 {
    static String[][] graph = new String[12][6];

    public static void main(String[] args) throws IOException {
        /**
         * 상하좌우로 4개 이상 연결
         *
         * 1. 상하좌우로 연결된 같은 뿌요가 4개 이상인지 확인 (상하좌우로 BFS) tmp에 저장
         * 2. 현재 위치 - tmp 위치에 있는 뿌요를 이동
         * 3. 하나도 없으면 종료
         */

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            graph[i] = br.readLine().split("");
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        List<Pair> toBeDeleted;
        int count = 0;
        while (true) {
            toBeDeleted = new ArrayList<>();
            boolean[][] visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && !graph[i][j].equals(".")) {
                        toBeDeleted.addAll(bfs3(i, j, visited));
                    }
                }
            }
            if (toBeDeleted.isEmpty()) {
                break;
            }
            delete(toBeDeleted);
            count++;
        }

        return count;
    }

    private static void delete(List<Pair> toBeDeleted) {
        for (Pair pair : toBeDeleted) {
            int x = (int) pair.getX();
            int y = (int) pair.getY();

            for (int i = x; i >= 0; i--) {
                graph[i][y] = i - 1 >= 0 ? graph[i - 1][y] : ".";
            }
        }
    }

    private static List<Pair> bfs3(int x, int y, boolean[][] visited) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        List<Pair> tmp = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(Pair.of(x, y));
        visited[x][y] = true;
        tmp.add(Pair.of(x, y));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = (int) pair.getX() + dx[i];
                int ty = (int) pair.getY() + dy[i];
                if (isWithinInclusive(tx, ty) && !visited[tx][ty] && Objects.equals(graph[(int) pair.getX()][(int) pair.getY()], graph[tx][ty])) {
                    queue.offer(Pair.of(tx, ty));
                    visited[tx][ty] = true;
                    tmp.add(Pair.of(tx, ty));
                }
            }
        }

        return tmp.size() >= 4 ? tmp : Collections.emptyList();
    }

    private static boolean isWithinInclusive(int x, int y) {
        return x >= 0 && x < 12 && y >= 0 && y < 6;
    }


    private static class Pair<T, R> {
        T x;
        R y;

        public static <T, R> Pair<T, R> of(T t, R r) {
            var result = new Pair<T, R>();
            result.x = t;
            result.y = r;
            return result;
        }

        public T getX() {
            return this.x;
        }

        public R getY() {
            return this.y;
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

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
