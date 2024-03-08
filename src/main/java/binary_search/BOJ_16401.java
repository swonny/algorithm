package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 과자 나눠주기
 */
public class BOJ_16401 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        final int[] snacks = new int[N];
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(snacks);
        final int answer = solve(M, N, snacks);
        System.out.println(answer);
    }

    private static int solve(int m, int n, int[] snacks) {
        int longest = snacks[n - 1];
        int l = 1;
        int r = longest;
        int mid = longest / 2;
        int count;

        while (l <= r) {
            if (mid <= 1) {
                return countSnacks(1, snacks) >= m ? 1 : 0;
            }
            count = countSnacks(mid, snacks);
            if (count >= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            mid = (r + l) / 2;
        }

        return mid;
    }

    private static int countSnacks(int mid, int[] snacks) {
        int count = 0;
        for (int i = snacks.length - 1; i >= 0; i--) {
            if (snacks[i] < mid) break;
            count += snacks[i] / mid;
        }

        return count;
    }
}
