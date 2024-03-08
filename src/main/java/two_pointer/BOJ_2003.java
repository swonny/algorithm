package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final String[] strings = br.readLine().split(" ");

        int[] cumNum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cumNum[i] = cumNum[i - 1] + Integer.parseInt(strings[i - 1]);
        }

        int left = 1;
        int right = 1;
        int count = 0;
        while (left <= right && right <= N) {
            final int tmp = cumNum[right] - cumNum[left - 1];
            if (tmp == M) {
                count++;
                right++;
            } else if (tmp > M) {
                left++;
            } else {
                right++;
            }
        }

        System.out.println(count);
    }
}
