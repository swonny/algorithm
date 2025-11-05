package 백준.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            d.add(i);
        }

        boolean isDelete = true;
        while (d.size() > 1) {
            if (isDelete) {
                d.removeFirst();
            } else {
                d.addLast(d.pop());
            }
            isDelete = !isDelete;
        }

        System.out.println(d.poll());
    }
}
