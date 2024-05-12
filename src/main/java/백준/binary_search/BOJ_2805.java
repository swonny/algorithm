package 백준.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        var N = Integer.parseInt(stringTokenizer.nextToken());
        var M = Integer.parseInt(stringTokenizer.nextToken());
        final long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        final long solution = solution(N, M, arr);
        System.out.println(solution);
    }

    public static long solution(int N, int M, long[] trees) {
        long r = Arrays.stream(trees).max().getAsLong() + 1;
        long l = 0;
        long mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            long sum = 0;
            for (long t : trees) {
                sum += t > mid ? t - mid : 0;
            }
            if (sum >= M) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l - 1;
    }
}
