package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_15649_v2 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        dfs(new ArrayList<>(), input.get(0), input.get(1));
    }

    private static void dfs(List<Integer> nums, int n, int m) {
        if (nums.size() == m) {
            System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!nums.contains(i)) {
                nums.add(i);
                dfs(nums, n, m);
                nums.remove(nums.size() - 1);
            }
        }
    }
}
