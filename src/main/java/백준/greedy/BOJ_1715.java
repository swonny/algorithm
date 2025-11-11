package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        var result = 0;
        while (pq.size() > 1) {
            var sum = pq.poll() + pq.poll();
            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }
}
