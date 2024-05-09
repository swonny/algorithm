package 백준.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int[] ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int m = Integer.parseInt(br.readLine());
        final int[] ms = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, ns, m, ms));
    }

    public static String solution(int N, int[] n, int M, int[] m) {
        var answer = new StringBuilder();

        Arrays.sort(n);
        for (int key : m) {
             int tmp = upperBound(n, key) - lowerBound(n, key);
            answer.append(tmp > 0 ? "1" : "0").append("\n");
        }
        return answer.toString();
    }

    public static int lowerBound(int[] arr, int key) {
        int left = 0,  right = arr.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (key <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int upperBound(int[] arr, int key) {
        int left = 0, right = arr.length;
        int mid;

        while (left < right) {
            mid = left + ((right - left) / 2);
            if (key >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
