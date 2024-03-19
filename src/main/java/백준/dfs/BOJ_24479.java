package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24479 {

    static int N;
    static int M;
    static int from;
    static List<Integer>[] graph;
    static int[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        from = Integer.parseInt(stringTokenizer.nextToken());

        graph = new List[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < N; i++) {
            Collections.sort(graph[i]);
        }

        count++;
        dfs(from);
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i] + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int from) {
        visited[from] = count;

        for (int next : graph[from]) {
            if (visited[next] == 0) {
                count++;
                dfs(next);
            }
        }
    }
}
