package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_v2 {
    static int n;
    static int answer = 0;
    static int[] queens;

    /**
     * [0, 0] ~ [n, n]까지 dfs로 탐색하여 queen n개가 모두 놓았을 때 answer++
     * - queen 위치는 1차원 배열로: [x, y] == queen[x] = y
     * - depth로 queen의 위치 관리
     * - depth == x
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queens = new int[n];
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queens[depth] = i;
            if (isPromise(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isPromise(int depth) {
        for (int i = 0; i < depth; i++) {
            if (queens[i] == queens[depth] || Math.abs(queens[i] - queens[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }

        return true;
    }
}
