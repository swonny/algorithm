package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while(left < right) {
                if (i == left) {
                    left++;
                    continue;
                }
                else if (right == i) {
                    right--;
                    continue;
                }

                final int sum = nums[left] + nums[right];
                if (sum > nums[i]) {
                    right--;
                } else if (sum < nums[i]) {
                    left++;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
