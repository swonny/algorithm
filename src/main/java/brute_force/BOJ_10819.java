package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_10819 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                                             .map(Integer::parseInt)
                                             .sorted()
                                             .collect(Collectors.toList());
        final int numberSize = numbers.size();

        final List<Integer> sortedNumbers = new ArrayList<>();
        boolean front = true;
        for (int i = 0; i < numberSize - 1; i++) {
            if (front) {
                sortedNumbers.add(numbers.get(i));
            }
            if (!front) {
                sortedNumbers.add(numbers.get(numberSize - i));
            }
        }

        final Deque<Integer> deque = new ArrayDeque<>(numbers);
        final List<Integer> ans = new ArrayList<>();
        ans.add(deque.removeFirst());
        ans.add(deque.removeLast());
        int sum = 0;
        for (int i = 1; i < sortedNumbers.size(); i++) {

        }
    }
}
