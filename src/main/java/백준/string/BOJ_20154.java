package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20154 {

    static int[] count = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] strings = br.readLine().toCharArray();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.offer(count[strings[i] - 'A']);
        }


        while (queue.size() > 1) {
            queue.offer(queue.poll() + queue.poll());
        }

        int res = queue.poll();
        System.out.println(res % 2 == 0 ? "You're the winner?" : "I'm a winner!");
    }
}
