package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_15650_v2 {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        dfs(new ArrayList<>());
    }

    private static void dfs(List<Integer> nums) {
        if (nums.size() == m) {
            System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isPromise(nums, i)) {
                nums.add(i);
                dfs(nums);
                nums.remove(nums.size() - 1);
            }
        }
    }

    private static boolean isPromise(List<Integer> nums, int toAdd) {
        return nums.isEmpty() || nums.get(nums.size() - 1) < toAdd;
    }
}
