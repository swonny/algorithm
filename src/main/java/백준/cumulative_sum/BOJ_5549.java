package 백준.cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_5549 {


    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st2.nextToken());
        final int M = Integer.parseInt(st2.nextToken());
        final int K = Integer.parseInt(br.readLine());

        int[][] jSum = new int[N + 1][M + 1];
        int[][] oSum = new int[N + 1][M + 1];
        int[][] iSum = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            final String[] strings = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                int jAdd = Objects.equals(strings[j - 1], "J") ? 1 : 0;
                jSum[i][j] = jSum[i][j - 1] + jAdd;
                int oAdd = Objects.equals(strings[j - 1], "O") ? 1 : 0;
                oSum[i][j] = oSum[i][j - 1] + oAdd;
                int iAdd = Objects.equals(strings[j - 1], "I") ? 1 : 0;
                iSum[i][j] = iSum[i][j - 1] + iAdd;
            }
        }

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                jSum[j][i] = jSum[j - 1][i] + jSum[j][i];
                oSum[j][i] = oSum[j - 1][i] + oSum[j][i];
                iSum[j][i] = iSum[j - 1][i] + iSum[j][i];
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int r1 = Integer.parseInt(st.nextToken());
            final int c1 = Integer.parseInt(st.nextToken());
            final int r2 = Integer.parseInt(st.nextToken());
            final int c2 = Integer.parseInt(st.nextToken());

            int jRes = jSum[r2][c2] - jSum[r2][c1 - 1] - jSum[r1 - 1][c2] + jSum[r1 - 1][c1 - 1];
            int oRes = oSum[r2][c2] - oSum[r2][c1 - 1] - oSum[r1 - 1][c2] + oSum[r1 - 1][c1 - 1];
            int iRes = iSum[r2][c2] - iSum[r2][c1 - 1] - iSum[r1 - 1][c2] + iSum[r1 - 1][c1 - 1];
            sb.append(jRes + " " + oRes + " " + iRes + " \n");
        }

        System.out.println(sb);
    }
}
