package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24483 {

    static int N;
    static int M;
    static int R;
    static Map<Integer, List<Integer>> graph;
    static int[] d;
    static int[] t;
    static int count = 0;
    static long result;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());

        d = new int[N + 1];
        t = new int[N + 1];

        graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        Arrays.fill(d, -1);

        d[R] = 0;
        dfs(R, 0);

        System.out.println(result);
    }

    public static void dfs(int start, int depth) {
        d[start] = depth;
        t[start] = ++count;
        result += (long) t[start] * depth;

        for (int next : graph.get(start)) {
            if (d[next] == -1) {
                dfs(next, depth + 1);
            }
        }
    }
}
