package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9575 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int[][] numbers = new int[3][];
            for (int j = 0; j < 3; j++) {
                var n = Integer.parseInt(br.readLine());
                var st = new StringTokenizer(br.readLine(), " ");
                numbers[j] = new int[n];
                for (int k = 0; k < n; k++) {
                    numbers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            solve(numbers[0], numbers[1], numbers[2]);
        }
    }

    private static void solve(int[] A, int[] B, int[] C) {
        boolean[] visited = new boolean[300_001];
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    var sum = a + b + c;
                    if (isLucky(sum) && !visited[sum]) {
                        visited[sum] = true;
                        res++;
                    }
                }
            }
        }

        System.out.println(res);
    }

    private static boolean isLucky(int value) {
        while (value > 0) {
            if (value % 10 != 8 && value % 10 != 5) return false;
            value /= 10;
        }

        return true;
    }
}
