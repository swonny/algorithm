package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st2.nextToken());
        final int s = Integer.parseInt(st2.nextToken());
        final String[] strings = br.readLine().split(" ");
        final int[] num = new int[n];
        num[0] = Integer.parseInt(strings[0]);
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }

        final int[] cumSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            cumSum[i] = cumSum[i - 1] + num[i - 1];
        }

        int left = 1;
        int right = 1;
        int ans = Integer.MAX_VALUE;
        int tmp;
        while (right < n + 1) {
            tmp = cumSum[right] - cumSum[left - 1];
            if (tmp >= s) {
                ans = Math.min(ans, right - left + 1);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(ans != Integer.MAX_VALUE ? ans : 0);
    }
}
