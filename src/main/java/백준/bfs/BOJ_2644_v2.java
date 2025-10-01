//package 백준.bfs;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.Set;
//import java.util.StringTokenizer;
//import java.util.stream.Collectors;
//
//public class BOJ_2644_v2 {
//
//    public static void main(String[] args) throws IOException {
//        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        final int n = Integer.parseInt(br.readLine());
//        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
//        final int s = Integer.parseInt(stringTokenizer.nextToken());
//        final int e = Integer.parseInt(stringTokenizer.nextToken());
//        final int m = Integer.parseInt(br.readLine());
//
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        Integer[] boxed = Arrays.stream(array).boxed().toArray(Integer[]::new);
//
//        Arrays.sort(boxed,
//                Comparator.comparingInt((Integer it) -> it % 10)
//                        .thenComparingInt(it -> it % 100)
//                        .thenComparingInt(it -> it % 1000)
//        );
//        Arrays.stream(array).boxed().collect(Collectors.toList());
//
//        int[][] arrays = {{1,2}, {3, 4,}};
//        Set<Map.Entry<String, String>> set = new HashSet<>();
//        Map<String, Integer> map = new HashMap<>();
//        Arrays.binarySearch(array, );
//
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < m; i++) {
//            final StringTokenizer st = new StringTokenizer(br.readLine());
//            final int parent = Integer.parseInt(st.nextToken());
//            final int child = Integer.parseInt(st.nextToken());
//
//            graph.putIfAbsent(parent, new ArrayList<>());
//            graph.putIfAbsent(child, new ArrayList<>());
//            graph.get(parent).add(child);
//            graph.get(child).add(parent);
//        }
//
//        final int[] distance = new int[n + 1];
//        Arrays.fill(distance, -1);
//        final int result = bfs(graph, distance, s, e);
//        System.out.println(result == 0 ? -1 : result);
//    }
//
//    public static int bfs(Map<Integer, List<Integer>> graph, int[] distance, int start, int end) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(start);
//        distance[start] = 0;
//        while (!queue.isEmpty()) {
//            final Integer v = queue.poll();
//            for (int n : graph.get(v)) {
//                if (distance[n] == -1) {
//                    distance[n] = distance[v] + 1;
//                    queue.offer(n);
//                }
//            }
//        }
//
//        return distance[end];
//    }
//}
