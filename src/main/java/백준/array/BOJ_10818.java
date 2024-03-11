package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {


    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final String[] strings = br.readLine().split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            final int cur = Integer.parseInt(strings[i]);
            min = Math.min(cur, min);
            max = Math.max(cur, max);
        }
        System.out.printf("%d %d", min, max);
    }
}
