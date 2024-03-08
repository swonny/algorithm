package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st2.nextToken());
        final int M = Integer.parseInt(st2.nextToken());

        int[][] cumSum = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            final String[] strings = br.readLine().split(" ");
            cumSum[i][1] = Integer.parseInt(strings[0]);
            for (int j = 2; j < N + 1; j++) {
                cumSum[i][j] = cumSum[i][j - 1] + Integer.parseInt(strings[j - 1]);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                cumSum[j][i] = cumSum[j - 1][i] + cumSum[j][i];
            }
        }

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int r1 = Integer.parseInt(st.nextToken());
            final int c1 = Integer.parseInt(st.nextToken());
            final int r2 = Integer.parseInt(st.nextToken());
            final int c2 = Integer.parseInt(st.nextToken());

            int tmp = cumSum[r2][c2] - cumSum[r2][c1 - 1] - cumSum[r1 - 1][c2] + cumSum[r1 - 1][c1 - 1];
            result.append(tmp + " \n");
        }

        System.out.println(result);
    }
}
