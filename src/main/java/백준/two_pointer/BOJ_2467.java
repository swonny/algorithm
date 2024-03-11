package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st2 = new StringTokenizer(br.readLine());

        final int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int minVal = Math.abs(num[left] + num[right]);
        int ansLeft = 0;
        int ansRight = N - 1;
        while (left != right) {
            if (minVal > Math.abs(num[left] + num[right])) {
                minVal = Math.abs(num[left] + num[right]);
                ansLeft = left;
                ansRight = right;
            }

            if (num[left] + num[right] >= 0) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        System.out.println(num[ansLeft] + " " + num[ansRight]);
    }
}
