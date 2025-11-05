package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649_v2 {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] nums = br.readLine().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);

        dfs("");
    }

    private static void dfs(String nums) {
        if (nums.length() == m*2) {
            System.out.println(nums);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!nums.contains(String.valueOf(i))) {
                nums = nums + i + " ";
                dfs(nums);
                nums = nums.substring(0, nums.length() - 2);
            }
        }
    }
}
