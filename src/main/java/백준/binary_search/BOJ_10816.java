package 백준.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ_10816 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] keys = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.stream(solution(N, cards, M, keys)).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    public static int[] solution(int N, int[] cards, int M, int[] keys) {
        int[] answer = new int[M];

        Arrays.sort(cards);
        for (int i =0; i < M; i++) {
            answer[i] = upperBound(cards, keys[i]) - lowerBound(cards, keys[i]);
        }

        return answer;
    }

    public static int upperBound(int[] cards, long key) {
        int left = 0;
        int right = cards.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (cards[mid] > key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int lowerBound(int[] cards, long key) {
        int left = 0;
        int right = cards.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (cards[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
