package 백준.dfs;

public class DFS_recursion {

    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {2}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for (int nextIdx : graph[idx]) {
            if (!visited[nextIdx]) {
                dfs(nextIdx);
            }
        }
    }
}
