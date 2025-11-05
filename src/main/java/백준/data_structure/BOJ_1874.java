package 백준.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        var sb = new StringBuilder();
        int current = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            s.push(i);
            sb.append("+\n");
            while (!s.isEmpty()) {
                if (s.peek() != numbers[current]) {
                    break;
                }
                sb.append("-\n");
                s.pop();
                current++;
            }
        }

        if (current != n) {
            System.out.println("NO");
            return;
        }

        System.out.println(sb);
    }
}
