package 백준.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_15650 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /***
         * - 정답 조건: depth == M
         * - 다음 깊이로 넘어가는 조건: 배열에 없는 숫자 & 이전 숫자보다 커야한다.
         */
        dfs(new ArrayList<>(), n, m);
    }

    public static void dfs(List<Integer> arr, int n, int m) {
        if (arr.size() == m) {
            System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!arr.contains(i) && (arr.size() == 0 || arr.get(arr.size() - 1) < i)) {
                arr.add(i);
                dfs(arr, n, m);
                arr.remove(arr.size() - 1);
            }
        }
    }
}
