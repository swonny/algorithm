package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_26215 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int minute = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            Integer second = pq.poll();

            first--;
            if (second != null) {
                second--;
            }

            if (first > 0) pq.add(first);
            if (second != null && second > 0) pq.add(second);

            minute++;
            if (minute > 1440) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(minute);
    }
}
