package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25916 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());
        final int[] num = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int left = 0;
        int right = 0;
        int sum = num[left];
        int max = -1;
        while (right < n) {
            if (sum < m) {
                max = Math.max(sum, max);
                right++;
                sum += right >= n ? 0 : num[right];
            } else if (sum > m) {
                sum -= num[left];
                left++;
            } else {
                max = m;
                break;
            }
        }
        System.out.println(max);
    }
}
