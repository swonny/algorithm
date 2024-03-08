package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

public class BOJ_14002 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final String[] arr = br.readLine().split(" ");
        final int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        final Stack<Integer>[] tmp = new Stack[N];
        final int[] dp = new int[N];

        Stack<Integer> answer = new Stack<>();
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            final Stack<Integer> num = new Stack<>();
            num.push(numbers[i]);
            tmp[i] = num;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] > tmp[j].peek()) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        tmp[i] = tmp[j];
                        tmp[i].push(numbers[i]);
                    } else if (dp[i] == dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        int curNumber = tmp[i].pop();
                        tmp[i] = tmp[i].peek() < tmp[j].peek() ? tmp[j] : tmp[i];
                        tmp[i].push(curNumber);
                    }
                }
            }
            if (answer.size() < tmp[i].size()) {
                answer = tmp[i];
            }
        }

        System.out.println(answer.size());
        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
