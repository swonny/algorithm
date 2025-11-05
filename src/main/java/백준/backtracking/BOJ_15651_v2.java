package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_15651_v2 {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(new ArrayList<>());

        System.out.println(sb.toString());
    }

    public static void dfs(List<Integer> nums) {
        if (nums.size() == m) {
            sb.append(nums.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            nums.add(i);
            dfs(nums);
            nums.remove(nums.size() - 1);
        }
    }
}
