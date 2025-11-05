package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class BOJ_1327 {
    static int n;
    static int k;
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        /**
         * queue 삽입 조건: visited에 포함되어 있지 않은 경우
         * 탐색 대상: for문으로 0 ~ (N-K)까지
         * 방문한 적 없으면 queue 삽입, visited 처리
         */
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final List<String> inputs = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        n = Integer.parseInt(inputs.get(0));
        k = Integer.parseInt(inputs.get(1));
        final String numbers = br.readLine().replace(" ", "");

        System.out.println(bfs(numbers));
    }

    public static int bfs(String numbers) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(Pair.of(numbers, 0));
        visited.add(numbers);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (isInOrder(pair.str)) {
                return pair.cnt;
            }
            for (int i = 0; i <= n - k; i++) {
                String t = new StringBuilder(pair.str.substring(i, i + k)).reverse().toString();
                t = pair.str.substring(0, i) + t + pair.str.substring(i + k, n);
                if (!visited.contains(t)) {
                    queue.offer(Pair.of(t, pair.cnt + 1));
                    visited.add(t);
                }
            }
        }
        return -1;
    }

    private static boolean isInOrder(String t) {
        int[] c = Arrays.stream(t.split("")).mapToInt(Integer::parseInt).toArray();
        for (int j = 1; j < n; j++) {
            if (c[j - 1] > c[j]) return false;
        }
        return true;
    }

    static class Pair {
        String str;
        int cnt;

        public Pair(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }

        public static Pair of(String str, int cnt) {
            return new Pair(str, cnt);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return cnt == pair.cnt && Objects.equals(str, pair.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str, cnt);
        }

        public String toString() {
            return "Pair: " + str + ", cnt: " + cnt;
        }
    }
}
