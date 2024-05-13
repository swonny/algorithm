package 백준.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2512 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final long[] cities = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        final long budget = Long.parseLong(br.readLine());

        System.out.println(solution(N, cities, budget));
    }

    public static long solution(int N, long[] cities, long budget) {
        long sum = Arrays.stream(cities).sum();
        if (sum <= budget) {
            return Arrays.stream(cities).max().getAsLong();
        }
        long l = 0, r = budget;
        long mid;

        while (l < r) {
            mid = l + (r - l) /2 ;
            sum = 0;
            for (long city : cities) {
                sum += Math.min(budget, city);
            }
            if (sum > budget) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l - 1;
    }
}
