package 백준.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");

        var n = Integer.parseInt(st.nextToken());
        var l = Integer.parseInt(st.nextToken());
        var numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        /**
         * 1. 큐 생성
         * 2. 마지막 원소보다 큰 값이 될 때까지 제거 후 Ai 추가
         * 3. 인덱스 범위 벗어나는 원소 제거
         * 4. 첫 번째 원소 출력
         *
         * Map.Entry<number, index>
         */
        Deque<int[]> q = new ArrayDeque<>();

        var sb = new StringBuilder();
        sb.append(numbers[0]).append(" ");
        q.add(new int[]{numbers[0], 0});
        for (int i = 1; i < n; i++) {
            while (!q.isEmpty()) {
                var last = q.peekLast();
                if (numbers[i] > last[0]) {
                    break;
                }
                q.removeLast();
            }

            q.addLast(new int[]{numbers[i], i});

            var start = Math.max(i - l + 1, 0);
            while (!q.isEmpty()) {
                var first = q.peekFirst();
                if (first[1] >= start) {
                    break;
                }
                q.removeFirst();
            }

            sb.append(q.peekFirst()[0]).append(" ");
        }

        System.out.println(sb);
    }
}
