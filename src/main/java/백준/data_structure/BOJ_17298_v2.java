package 백준.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class BOJ_17298_v2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        /**
         * 오큰수 조건
         * 1. 현재 값보다 커야함
         * 2. 현재 값보다 오른쪽에 있어야함
         * 3. 1, 2를 만족하는 수 중 가장 왼쪽에 있어야 함
         *
         * stack을 활용하면 위 조건을 만족할 수 있음
         *
         * 수열 첫 번째 원소부터 차례로 스택에 담음
         * 스택에 push 전 현재 값이 스택의 마지막 원소보다 클 경우 현재 값이 스택의 마지막 원소의 오큰수 조건을 만족함
         * - 1번 만족
         * - 스택에 이미 들어 있다 = 현재값보다 앞에 있는 원소이다 = 오른쪽에 있는 원소이다
         * - 매번 확인하여 가장 처음 발견하는 1, 2를 만족하는 수이므로 가장 왼쪽에 있음
         *
         * 현재값보다 작은 수를 모두 pop하여 인덱스에 해당하는 결과에 현재값을 오큰수로 넣음
         * 더이상 스택에 넣을 값이 없으면 종료.
         * 스택에 남아있는 값들은 모두 오큰수가 없는 원소들
         */
        Stack<Integer> s = new Stack<>();
        s.push(0);
        var result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                result[s.pop()] = numbers[i];
            }

            s.push(i);
        }

        System.out.println(Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
