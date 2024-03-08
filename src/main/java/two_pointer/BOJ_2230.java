package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st2 = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st2.nextToken());
        final int M = Integer.parseInt(st2.nextToken());

        final int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        while (left <= right && right < N) {
            final int distance = num[right] - num[left];

            if (distance < M) {
                right += 1;
            } else if (distance > M) {
                answer = Math.min(distance, answer);
                left += 1;
            } else {
                answer = distance;
                break;
            }
        }

        System.out.println(answer);
    }
}
