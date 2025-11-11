package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        /**
         * 목표: 수열의 합이 최대가 되도록 수열을 묶는다.
         * 조건
         *  - 두 수를 더해서 묶는다.
         *  - 두 수를 묶게되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
         *  - 단 한번만 묶거나 아예 묶지 않아야함
         *
         *  규칙
         *  - 1인 경우 개수 카운팅
         *  - 0인 경우 개수 카운팅
         *
         *  - 음수인 경우 오름차순으로 정렬하여 곱하기
         *  - 1보다 큰 경우 내림차순으로 정렬하여 곱하기
         *
         *  음수가 1개 남은 경우
         *     - 0이 있으면 0 곱하기
         *  1보다 큰 수 남은 수, 남은 1 모두 더하기
         */

        var one = 0;
        var zero = 0;
        Queue<Integer> negatives = new PriorityQueue<>();
        Queue<Integer> positives = new PriorityQueue<>(Comparator.reverseOrder()); // 1보다 큰 수들
        for (int i = 0; i < n; i++) {
            var number = Integer.parseInt(br.readLine());
            if (number == 1) one++;
            else if (number == 0) zero++;
            else if (number > 1) positives.offer(number);
            else if (number < 0) negatives.offer(number);
        }

        var result = one;
        while (negatives.size() > 1) {
            result += (negatives.poll() * negatives.poll());
        }

        while (positives.size() > 1) {
            result += (positives.poll() * positives.poll());
        }

        if (!negatives.isEmpty()) {
            if (zero == 0) result += negatives.poll();
        }

        if (!positives.isEmpty()) result += positives.poll();

        System.out.println(result);
    }
}
