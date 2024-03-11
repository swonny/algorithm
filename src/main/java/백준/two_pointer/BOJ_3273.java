package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final String[] strings = br.readLine().split(" ");
        final int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(nums);
        final int x = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                final int curNum = nums[i] + nums[j];
                if (curNum == x) {
                    count++;
                    break;
                } else if (curNum < x) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
