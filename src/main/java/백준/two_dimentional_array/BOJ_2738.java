package 백준.two_dimentional_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2738 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        final int[][] a1 = new int[N][M];
        final int[][] a2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            a1[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < N; i++) {
            a2[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(Arrays.deepToString(a1));
        System.out.println(Arrays.deepToString(a2));

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(a1[i][j] + a2[i][j]).append(" ");
                System.out.println(a1[i][j] + a2[i][j]);
            }
            System.out.println(String.join(sb));
        }
    }
}
