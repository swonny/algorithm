package 백준.binary_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * three dots
 */
public class BOJ_13423 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            final int n = Integer.parseInt(br.readLine());
            final List<Integer> dots = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            final int answer = solve(n, dots);
            System.out.println(answer);
        }
    }

    private static int solve(int n, List<Integer> tmp) {
        final int[] dots = new int[n];
        for (int i = 0; i < n; i++) {
            dots[i] = tmp.get(i);
        }

        int l = 0;
        int r = n - 1;
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(dots[j] - dots[i]);
                if (binSearch(j + 1, n - 1, dots[j] + distance, dots)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private static boolean binSearch(int l, int r, int target, int[] dots) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (dots[mid] == target) {
                return true;
            }
            if (dots[mid] < target) {
                l = mid + 1;
            } else if (dots[mid] > target) {
                r = mid - 1;
            }
        }
        return false;
    }
}
