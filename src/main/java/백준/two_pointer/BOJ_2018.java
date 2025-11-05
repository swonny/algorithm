package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        numbers[1] = 1;
        for (int i = 2; i < n; i++) {
            numbers[i] += numbers[i - 1] + i;
        }

        int left = 0;
        int right = 1;
        int count = 0;
        while (left < right && right < n) {
            int tmp = numbers[right] - numbers[left];
            if (tmp == n) {
                count++;
                right++;
            }
            else if (tmp > n) left++;
            else right++;
        }

        System.out.println(count + 1);
    }
}
