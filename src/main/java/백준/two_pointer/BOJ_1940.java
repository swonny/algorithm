package 백준.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var m = Integer.parseInt(br.readLine());
        var numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);
        int count = 0;
        int left = 0;
        int right = n - 1;
        while (left < right && right < n) {
            int tmp = numbers[left] + numbers[right];
            if (tmp == m) {
                count++;
                right--;
            } else if (tmp < m) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
