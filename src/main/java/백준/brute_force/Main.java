package 백준.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1. 오름차순 정렬
 * 2. 두 번째 숫자 ~ list.size() - 1까지 확인
 * a) Xb - Xa = Z, Xb + Z = ?
 * b) ?에 해당하는 값이 존재하면 count++
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int count = calculateResult(br);
            System.out.println(count);
        }
    }

    private static int calculateResult(final BufferedReader br) throws IOException {
        final int N = Integer.parseInt(br.readLine());
        final List<Integer> dots = Arrays.stream(br.readLine().split(" "))
                                         .map(Integer::parseInt)
                                         .sorted()
                                         .collect(Collectors.toUnmodifiableList());

        final Set<Integer> set = new HashSet<>(dots);
        int count = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < i; j++) {
                int Z = dots.get(i) - dots.get(j);
                count += set.contains(dots.get(i) + Z) ? 1 : 0;
            }
        }

        return count;
    }
}
