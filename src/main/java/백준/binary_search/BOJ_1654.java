package 백준.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(K, N, arr));
    }

    public static long solution(long K, long N, long[] lines) {
        long left = 0, right = Arrays.stream(lines).max().getAsLong() + 1;

        while (left < right) {
            long mid = left + ((right - left) / 2);
            long count = 0;
            for (long l : lines) {
                count += l / mid;
            }
            if (count < K) {
                right = mid;
            } else {
                left = mid + 1;
            }
//
//            if (count < K) {
//                right = mid - 1;
//            } else {
//                left = mid;
//            }
        }

        return left - 1;
    }
}
