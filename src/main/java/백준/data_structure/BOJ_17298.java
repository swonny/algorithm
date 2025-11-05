package 백준.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        /**
         * Ai의 오큰수 조건
         * 1. 인덱스가 i보다 커야함
         * 2. Ai보다 커야함
         * 3. 그 중 가장 왼쪽에 있어야 함
         *
         * 스택에 추가하려는 값과 스택의 가장 최상단의 값을 비교했을 때 추가하려는 값 > 스택 최상단 값이면 오큰수이다.
         * 1. 수열의 0번째 원소부터 스택에 넣기 때문에 1번 만족
         * 2. 스택 추가 조건 때문에 2번 만족
         * 3. 마찬가지로 0번째부터 뒤로 가면서 스택에 추가하기 때문에 가장 먼저 스택에 들어간 원소가 가장 왼쪽의 원소이다.
         *    그리고 스택에 추가할 때마다 비교하기 때문에, 가장 첫 번째로 발견되는 값이 정답
         *
         *
         * [풀이]
         * 1. 스택에 A0 push
         * 2. 스택 Peek과 Ai 비교 후 Peek < Ai가 될 때까지 pop해서 오큰수로 저장
         * 3. Ai push
         * 4. 스택에 넣을 값 없으면 종료 & 스택에 남아있는 값들은 오큰수가 없다는 의미
         */

        var result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                result[s.pop()] = numbers[i];
            }
            s.push(i);
        }

        System.out.println(Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
