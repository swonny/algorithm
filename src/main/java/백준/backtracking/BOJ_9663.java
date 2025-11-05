package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int[] queens;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queens = new int[n];

        nqueens(0);

        System.out.println(count);
    }

    public static void nqueens(int depth) {
        if (depth == queens.length) {
            count++;
            return;
        }

        for (int i = 0; i < queens.length; i++) {
            queens[depth] = i;
            if (isPromise(depth)) {
                nqueens(depth + 1);
            }
        }
    }

    public static boolean isPromise(int depth) {
        for (int i = 0; i < depth; i++) {
            if (queens[i] == queens[depth] || Math.abs(queens[i] - queens[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }

        return true;
    }
}
