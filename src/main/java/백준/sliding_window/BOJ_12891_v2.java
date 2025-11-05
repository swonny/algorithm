package 백준.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_12891_v2 {
    private static final char[] dna = "ACGT".toCharArray();

    public static void main(String[] args) throws IOException {
        // log n까지 가능
        var br = new BufferedReader(new InputStreamReader(System.in));
        var lengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var string = br.readLine().toCharArray();

        var targetCount = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Character, Integer> targetCounts = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            targetCounts.put(dna[i], targetCount[i]);
        }

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            counts.put(dna[i], 0);
        }

        int answer = 0;
        for (int i = 0; i < lengths[1]; i++) {
            char a = string[i];
            counts.put(a, counts.getOrDefault(a,0) + 1);
        }
        if (isDna(counts, targetCounts)) {
            answer++;
        }

        for (int i = 1; i <= lengths[0] - lengths[1]; i++) {
            char toDelete = string[i - 1];
            counts.put(toDelete, counts.getOrDefault(toDelete,0) - 1);
            char toAdd = string[i + lengths[1] - 1];
            counts.put(toAdd, counts.getOrDefault(toAdd,0) + 1);

            if (isDna(counts, targetCounts)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean isDna(Map<Character, Integer> counts, Map<Character, Integer> targetCounts) {
        for (var key : targetCounts.keySet()) {
            if (counts.get(key) < targetCounts.get(key)) {
                return false;
            }
        }

        return true;
    }
}
